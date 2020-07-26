package com.br.laaila.reservas.laailareservas.model.response

import com.br.laaila.reservas.laailareservas.model.entity.ExternalType
import com.br.laaila.reservas.laailareservas.model.entity.Permissao

data class UsuarioResponse(
        val email: String,
        var nome: String,
        var contato: String,
        var permissoes: MutableList<Permissao>?,
        var ativo: Boolean,
        var externalClientType: ExternalType? = null,
        var externalClientId: String? = null
)