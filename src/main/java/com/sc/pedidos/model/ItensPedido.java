package com.sc.pedidos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "itens_pedido")
public class ItensPedido implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NotNull
    @JoinColumn(name = "produto_servico_id", nullable = false)
    @ManyToOne
    private ProdutoServico produtoServico;

    @NotNull
    @JoinColumn(name = "pedido_id", nullable = false)
    @ManyToOne
    @JsonIgnore
    private Pedido pedido;

    @Min(1)
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotNull ProdutoServico getProdutoServico() {
        return produtoServico;
    }

    public void setProdutoServico(@NotNull ProdutoServico produtoServico) {
        this.produtoServico = produtoServico;
    }

    public @NotNull Pedido getPedido() {
        return pedido;
    }

    public void setPedido(@NotNull Pedido pedido) {
        this.pedido = pedido;
    }

    public @Min(1) Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(@Min(1) Integer quantidade) {
        this.quantidade = quantidade;
    }
}
