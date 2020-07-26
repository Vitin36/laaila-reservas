package com.br.laaila.reservas.laailareservas.model.entity

import javax.persistence.*

@Entity
data class Produto(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
        @SequenceGenerator(name = "produto", sequenceName = "produto_seq", allocationSize = 1)
        val id: Long = -1,
        var nome: String,
        var valor: Long,
        var descricao: String,
        var ativo: Boolean = true,
        @ManyToOne(fetch = FetchType.LAZY)
        var catalogo: Catalogo
)