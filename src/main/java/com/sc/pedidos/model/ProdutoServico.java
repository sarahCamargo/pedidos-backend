package com.sc.pedidos.model;

import com.sc.pedidos.model.enums.SituacaoProdutoServico;
import com.sc.pedidos.model.enums.TipoItem;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "produto_servico")
public class ProdutoServico implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @NotNull
    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

    @NotNull
    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoItem tipo;

    @NotNull
    @Column(name = "situacao", nullable = false)
    @Enumerated(EnumType.STRING)
    private SituacaoProdutoServico situacao;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotNull String getNome() {
        return nome;
    }

    public void setNome(@NotNull String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public @NotNull BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(@NotNull BigDecimal preco) {
        this.preco = preco;
    }

    public @NotNull TipoItem getTipo() {
        return tipo;
    }

    public void setTipo(@NotNull TipoItem tipo) {
        this.tipo = tipo;
    }

    public @NotNull SituacaoProdutoServico getSituacao() {
        return situacao;
    }

    public void setSituacao(@NotNull SituacaoProdutoServico situacao) {
        this.situacao = situacao;
    }
}
