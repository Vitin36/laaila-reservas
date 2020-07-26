package com.br.laaila.reservas.laailareservas.infrastructure.exception

import com.br.laaila.reservas.laailareservas.infrastructure.errors.ErrorCode

data class BaseExceptionMessage(
        val code: ErrorCode,
        val message: String? = null
)