package com.br.laaila.reservas.laailareservas.model.entity

import java.util.*
import javax.persistence.*

@Entity
open class Catalogo(
        @Id
        open val id: UUID = UUID.randomUUID(),
        open var nome: String,
        open var descricao: String?,
        open var ativo: Boolean = true,
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogo")
        open var produtos: List<Produto> = emptyList()
)