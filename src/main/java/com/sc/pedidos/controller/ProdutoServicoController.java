package com.sc.pedidos.controller;

import com.sc.pedidos.model.ProdutoServico;
import com.sc.pedidos.service.ProdutoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtoServico")
public class ProdutoServicoController {

    @Autowired
    private ProdutoServicoService service;

    @GetMapping
    public List<ProdutoServico> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoServico> buscarPorId(@PathVariable Long id) {
        ProdutoServico produtoServico = service.buscarPorId(id);
        if (produtoServico == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtoServico);
    }

    @PostMapping
    public ResponseEntity<ProdutoServico> adicionar(@RequestBody ProdutoServico produtoServico) {
        return ResponseEntity.ok(service.salvar(produtoServico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoServico> alterar(@RequestBody ProdutoServico produtoServicoAlterado, @PathVariable Long id) {
        ProdutoServico produtoServico = service.buscarPorId(id);
        if (produtoServico == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.salvar(produtoServicoAlterado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoServico> excluir(@PathVariable Long id) {
        ProdutoServico produtoServico = service.buscarPorId(id);
        if (produtoServico == null) {
            return ResponseEntity.notFound().build();
        }
        service.excluir(produtoServico);
        return ResponseEntity.ok(produtoServico);
    }

}
