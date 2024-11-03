package com.sc.pedidos.service;

import com.sc.pedidos.model.ProdutoServico;
import com.sc.pedidos.repository.ProdutoServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServicoService {

    @Autowired
    private ProdutoServicoRepository repository;

    public List<ProdutoServico> findAll() {
        return repository.findAll();
    }

    public ProdutoServico findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ProdutoServico save(ProdutoServico produtoServico) {
        return repository.save(produtoServico);
    }

    public void delete(ProdutoServico produtoServico) {
        repository.delete(produtoServico);
    }

}
