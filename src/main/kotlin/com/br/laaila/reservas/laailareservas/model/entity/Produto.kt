package com.br.laaila.reservas.laailareservas.model.entity

import java.util.*
import javax.persistence.*

@Entity
data class Produto(
        @Id
        val id: UUID = UUID.randomUUID(),
        var nome: String,
        var valor: Double,
        var descricao: String,
        var ativo: Boolean = true,
        @ManyToOne(fetch = FetchType.LAZY)
        var catalogo: Catalogo
)