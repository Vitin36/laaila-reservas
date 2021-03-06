package com.br.laaila.reservas.laailareservas.infrastructure.exception

import com.br.laaila.reservas.laailareservas.infrastructure.errors.ErrorCode
import java.lang.Exception

abstract class BaseException(val code: ErrorCode, override val message: String? = null) : Exception()