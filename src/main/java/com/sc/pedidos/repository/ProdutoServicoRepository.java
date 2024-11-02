package com.sc.pedidos.repository;

import com.sc.pedidos.model.ProdutoServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoServicoRepository extends JpaRepository<ProdutoServico, Long> {
}
