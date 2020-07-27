package com.br.laaila.reservas.laailareservas.model.entity

import javax.persistence.*

@Entity
open class ProdutoQuantidade(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_quantidade")
        @SequenceGenerator(name = "produto_quantidade", sequenceName = "produto_quantidade_seq", allocationSize = 1)
        open val id: Long = -1,
        open val quantidade: Int,
        @ManyToOne
        open val produto: Produto,
        @ManyToOne
        open val carrinho: Carrinho? = null
)