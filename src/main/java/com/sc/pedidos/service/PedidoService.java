package com.sc.pedidos.service;

import com.sc.pedidos.model.Pedido;
import com.sc.pedidos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public List<Pedido> buscarTodos() {
        return repository.findAll();
    }

    public Pedido buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Pedido salvar(Pedido pedido) {
        return repository.save(pedido);
    }

    public void excluir(Pedido pedido) {
        repository.delete(pedido);
    }
}
