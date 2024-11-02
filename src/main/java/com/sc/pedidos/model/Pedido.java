package com.sc.pedidos.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;

    @Column(name = "situacao", nullable = false)
    private SituacaoPedido situacao;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public SituacaoPedido getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoPedido situacao) {
        this.situacao = situacao;
    }
}
