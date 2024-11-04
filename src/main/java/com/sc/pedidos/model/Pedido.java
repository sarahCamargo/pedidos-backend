package com.sc.pedidos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sc.pedidos.model.enums.SituacaoPedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "situacao", nullable = false)
    private SituacaoPedido situacao;

    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER)
    private List<ItensPedido> itensPedido;

    @Column(name = "percentual_desconto")
    private BigDecimal percentualDesconto;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotNull BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(@NotNull BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public @NotNull SituacaoPedido getSituacao() {
        return situacao;
    }

    public void setSituacao(@NotNull SituacaoPedido situacao) {
        this.situacao = situacao;
    }

    public List<ItensPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItensPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public BigDecimal getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(BigDecimal percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }
}
