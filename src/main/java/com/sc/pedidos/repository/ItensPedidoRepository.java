package com.sc.pedidos.repository;

import com.sc.pedidos.model.ItensPedido;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItensPedidoRepository extends JpaRepository<ItensPedido, UUID> {

    @Modifying @Transactional
    @Query(value = "delete from itens_pedido where pedido_id = :pedidoId", nativeQuery = true)
    void deleteByPedidoId(@Param("pedidoId") UUID pedidoId);

    @Query(value = "select * from itens_pedido where produto_servico_id = :produto_servico_id", nativeQuery = true)
    ItensPedido findByProdutoId(@Param("produto_servico_id") UUID produto_servico_id);
}
