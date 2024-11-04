package com.sc.pedidos.service;

import com.sc.pedidos.model.ItensPedido;
import com.sc.pedidos.repository.ItensPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItensPedidoService {

    @Autowired
    private ItensPedidoRepository repository;


    public void saveAll(List<ItensPedido> itensPedido) {
        repository.saveAll(itensPedido);
    }

    public void deleteByPedidoId(UUID pedidoID) {
        repository.deleteByPedidoId(pedidoID);
    }

    public ItensPedido findByProdutoId(UUID produtoId) {
        return repository.findByProdutoId(produtoId);
    }
}
