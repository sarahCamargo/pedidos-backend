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

    public List<Pedido> findAll() {
        return repository.findAll();
    }

    public Pedido findByID(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Pedido save(Pedido pedido) {
        return repository.save(pedido);
    }

    public void delete(Pedido pedido) {
        repository.delete(pedido);
    }
}
