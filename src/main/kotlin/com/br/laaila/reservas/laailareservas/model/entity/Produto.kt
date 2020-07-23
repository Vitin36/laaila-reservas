package com.br.laaila.reservas.laailareservas.model.entity

import javax.persistence.*

@Entity
data class Produto(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1,
        var nome: String,
        var valor: Long,
        var descricao: String,
        @ManyToOne(fetch = FetchType.LAZY)
        var catalogo: Catalogo
)