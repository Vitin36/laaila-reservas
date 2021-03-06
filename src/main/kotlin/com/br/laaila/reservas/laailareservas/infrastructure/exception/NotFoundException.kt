package com.br.laaila.reservas.laailareservas.infrastructure.exception

import com.br.laaila.reservas.laailareservas.infrastructure.errors.LaailaErrors

class NotFoundException(override val message: String? = null) : BaseException(LaailaErrors.NOT_FOUND_ERROR, message)