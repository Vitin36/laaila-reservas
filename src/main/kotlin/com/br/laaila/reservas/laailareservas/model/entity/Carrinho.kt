package com.br.laaila.reservas.laailareservas.model.entity

import javax.persistence.*

@Entity
open class Carrinho(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carrinho")
        @SequenceGenerator(name = "carrinho", sequenceName = "carrinho_seq", allocationSize = 1)
        open val id: Long = -1,
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "carrinho")
        open val itens: MutableList<ProdutoQuantidade> = mutableListOf(),
        @OneToOne
        open val usuario: Usuario
)