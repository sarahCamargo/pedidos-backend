package com.sc.pedidos.controller;

import com.sc.pedidos.model.Pedido;
import com.sc.pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping
    public List<Pedido> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable UUID id) {
        Pedido pedido = service.findByID(id);
        if (pedido == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pedido);
    }

    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody Pedido pedido) throws Exception {
        return ResponseEntity.ok(service.save(pedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> update(@RequestBody Pedido pedidoAlterado, @PathVariable UUID id) throws Exception {
        Pedido pedido = service.findByID(id);
        if (pedido == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.save(pedidoAlterado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pedido> excluir(@PathVariable UUID id) {
        Pedido pedido = service.findByID(id);
        if (pedido == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(pedido);
        return ResponseEntity.ok(pedido);
    }

}
