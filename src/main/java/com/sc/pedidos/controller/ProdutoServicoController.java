package com.sc.pedidos.controller;

import com.sc.pedidos.model.ProdutoServico;
import com.sc.pedidos.service.ProdutoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto-servico")
public class ProdutoServicoController {

    @Autowired
    private ProdutoServicoService service;

    @GetMapping
    public List<ProdutoServico> buscarTodos() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoServico> buscarPorId(@PathVariable Long id) {
        ProdutoServico produtoServico = service.findById(id);
        if (produtoServico == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtoServico);
    }

    @PostMapping
    public ResponseEntity<ProdutoServico> adicionar(@RequestBody ProdutoServico produtoServico) {
        return ResponseEntity.ok(service.save(produtoServico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoServico> alterar(@RequestBody ProdutoServico produtoServicoAlterado, @PathVariable Long id) {
        ProdutoServico produtoServico = service.findById(id);
        if (produtoServico == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.save(produtoServicoAlterado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoServico> excluir(@PathVariable Long id) {
        ProdutoServico produtoServico = service.findById(id);
        if (produtoServico == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(produtoServico);
        return ResponseEntity.ok(produtoServico);
    }

}
