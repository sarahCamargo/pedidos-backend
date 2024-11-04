package com.sc.pedidos.repository;

import com.sc.pedidos.model.ProdutoServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoServicoRepository extends JpaRepository<ProdutoServico, UUID> {
}
