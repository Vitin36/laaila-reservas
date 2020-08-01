package com.br.laaila.reservas.laailareservas.model.response

import java.util.UUID

data class ProdutoResponse(
        val id: UUID,
        val nome: String,
        val valor: Double,
        val descricao: String,
        val catalogo: UUID,
        val ativo: Boolean
)