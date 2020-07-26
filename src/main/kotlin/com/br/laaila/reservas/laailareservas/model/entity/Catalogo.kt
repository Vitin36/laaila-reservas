package com.br.laaila.reservas.laailareservas.model.entity

import javax.persistence.*

@Entity
open class Catalogo(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogo")
        @SequenceGenerator(name = "catalogo", sequenceName = "catalogo_seq", allocationSize = 1)
        open val id: Long = -1,
        open var nome: String,
        open var descricao: String?,
        open var ativo: Boolean = true,
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogo")
        open var produtos: List<Produto> = emptyList()
)