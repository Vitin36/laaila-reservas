package com.br.laaila.reservas.laailareservas.infrastructure.exception

import com.br.laaila.reservas.laailareservas.infrastructure.errors.ErrorCode
import java.lang.Exception

open class BaseException(code: ErrorCode, message: String? = null) : Exception()