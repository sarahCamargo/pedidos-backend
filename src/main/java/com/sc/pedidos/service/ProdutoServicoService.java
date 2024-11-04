package com.sc.pedidos.service;

import com.sc.pedidos.model.ItensPedido;
import com.sc.pedidos.model.ProdutoServico;
import com.sc.pedidos.repository.ProdutoServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoServicoService {

    @Autowired
    private ProdutoServicoRepository repository;

    @Autowired
    private ItensPedidoService itensPedidoService;

    public List<ProdutoServico> findAll() {
        return repository.findAll();
    }

    public ProdutoServico findById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public ProdutoServico save(ProdutoServico produtoServico) {
        return repository.save(produtoServico);
    }

    public void delete(ProdutoServico produtoServico) {
        ItensPedido itensPedido = itensPedidoService.findByProdutoId(produtoServico.getId());
        if (itensPedido != null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Não é possível excluir produto vinculado à um pedido"
            );
        }
        repository.delete(produtoServico);
    }

}
