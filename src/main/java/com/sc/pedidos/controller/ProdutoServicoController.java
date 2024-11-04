package com.sc.pedidos.controller;

import com.sc.pedidos.model.ProdutoServico;
import com.sc.pedidos.service.ProdutoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produto-servico")
public class ProdutoServicoController {

    @Autowired
    private ProdutoServicoService service;

    @GetMapping
    public List<ProdutoServico> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoServico> findById(@PathVariable UUID id) {
        ProdutoServico produtoServico = service.findById(id);
        if (produtoServico == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtoServico);
    }

    @PostMapping
    public ResponseEntity<ProdutoServico> save(@RequestBody ProdutoServico produtoServico) {
        return ResponseEntity.ok(service.save(produtoServico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoServico> update(@RequestBody ProdutoServico produtoServicoAlterado, @PathVariable UUID id) {
        ProdutoServico produtoServico = service.findById(id);
        if (produtoServico == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.save(produtoServicoAlterado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoServico> delete(@PathVariable UUID id) throws Exception {
        ProdutoServico produtoServico = service.findById(id);

        if (produtoServico == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(produtoServico);
        return ResponseEntity.ok(produtoServico);
    }

}
