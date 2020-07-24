package com.br.laaila.reservas.laailareservas.model.entity

import javax.persistence.*

@Entity
open class Catalogo(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        open val id: Long = -1,
        open var nome: String,
        open var descricao: String?,
        open var status: CatalogoStatus = CatalogoStatus.ABERTO,
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogo")
        open var produtos: List<Produto> = emptyList()
)

enum class CatalogoStatus(val status: String) {
    ABERTO("ABERTO"),
    FECHADO("FECHADO")
}