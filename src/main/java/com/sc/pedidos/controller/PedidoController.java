package com.sc.pedidos.controller;

import com.sc.pedidos.model.Pedido;
import com.sc.pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping
    public List<Pedido> buscarTodos() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        Pedido pedido = service.findByID(id);
        if (pedido == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pedido);
    }

    @PostMapping
    public ResponseEntity<Pedido> adicionar(@RequestBody Pedido pedido) {
        return ResponseEntity.ok(service.save(pedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> alterar(@RequestBody Pedido pedidoAlterado, @PathVariable Long id) {
        Pedido pedido = service.findByID(id);
        if (pedido == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.save(pedidoAlterado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pedido> excluir(@PathVariable Long id) {
        Pedido pedido = service.findByID(id);
        if (pedido == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(pedido);
        return ResponseEntity.ok(pedido);
    }

}
