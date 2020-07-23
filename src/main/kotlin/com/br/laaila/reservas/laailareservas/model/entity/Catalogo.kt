package com.br.laaila.reservas.laailareservas.model.entity

import javax.persistence.*

@Entity
class Catalogo(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1,
        var nome: String,
        var descricao: String?,
        var status: CatalogoStatus = CatalogoStatus.ABERTO,
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogo")
        var produtos: List<Produto> = emptyList()
)

enum class CatalogoStatus(val status: String) {
    ABERTO("ABERTO"),
    FECHADO("FECHADO")
}