package com.sc.pedidos.service;

import com.sc.pedidos.model.ItensPedido;
import com.sc.pedidos.model.Pedido;
import com.sc.pedidos.model.ProdutoServico;
import com.sc.pedidos.model.enums.SituacaoPedido;
import com.sc.pedidos.model.enums.SituacaoProdutoServico;
import com.sc.pedidos.model.enums.TipoItem;
import com.sc.pedidos.repository.PedidoRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ItensPedidoService itensPedidoService;

    public List<Pedido> findAll() {
        return repository.findAll();
    }

    public Pedido findByID(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public Pedido save(Pedido pedido) {
        List<ItensPedido> itensPedidos = pedido.getItensPedido();

        if (pedido.getId() != null) {
            resetItensPedidoId(pedido);
        }

        pedido.setItensPedido(null);
        Pedido pedidoSalvo = repository.save(pedido);

        this.setItensPedidoId(pedidoSalvo, itensPedidos);
        this.calcularValorTotal(pedidoSalvo, itensPedidos);

        itensPedidoService.saveAll(itensPedidos);
        pedidoSalvo.setItensPedido(itensPedidos);
        return pedidoSalvo;
    }

    private BigDecimal calcularDesconto(Pedido pedido, ItensPedido itensPedido) {
        BigDecimal produtoPreco = itensPedido.getProdutoServico().getPreco();
        BigDecimal valorTotalProdutos = produtoPreco.multiply(new BigDecimal(itensPedido.getQuantidade()));

        if (SituacaoPedido.FECHADO.equals(pedido.getSituacao()) && pedido.getPercentualDesconto() != null && !Objects.equals(pedido.getPercentualDesconto(), new BigDecimal("0"))) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Não é possível inserir desconto em pedidos fechados"
            );
        }

        if (pedido.getPercentualDesconto() != null) {
            BigDecimal percentual = pedido.getPercentualDesconto().divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
            return valorTotalProdutos.subtract(valorTotalProdutos.multiply(percentual));
        }
        return  valorTotalProdutos;
    }

    private void resetItensPedidoId(Pedido pedido) {
        itensPedidoService.deleteByPedidoId(pedido.getId());
        for (ItensPedido item : pedido.getItensPedido()) {
            item.setId(null);
        }
    }

    private void setItensPedidoId(Pedido pedidoSalvo, List<ItensPedido> itensPedidos) {
        for (ItensPedido item : itensPedidos) {
            if (SituacaoProdutoServico.DESATIVADO.equals(item.getProdutoServico().getSituacao())){
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Não é possível adicionar produtos desativados"
                );
            }
            item.setPedido(pedidoSalvo);
        }
    }

    private void calcularValorTotal(Pedido pedidoSalvo, List<ItensPedido> itensPedidos) {
        BigDecimal valorTotalDesconto = new BigDecimal("0");
        for (ItensPedido item : itensPedidos) {
            item.setPedido(pedidoSalvo);
            if (TipoItem.PRODUTO.equals(item.getProdutoServico().getTipo())) {
                valorTotalDesconto = valorTotalDesconto.add(calcularDesconto(pedidoSalvo, item));
            } else {
                valorTotalDesconto = valorTotalDesconto.add(item.getProdutoServico().getPreco());
            }
        }
        pedidoSalvo.setValorTotal(valorTotalDesconto);
    }

    public void delete(Pedido pedido) {
        itensPedidoService.deleteByPedidoId(pedido.getId());
        repository.delete(pedido);
    }
}
