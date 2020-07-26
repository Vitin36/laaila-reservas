package com.br.laaila.reservas.laailareservas.infrastructure.exception

import com.br.laaila.reservas.laailareservas.infrastructure.errors.LaailaErrors

class NotPermittedOperationException(override val message: String? = null) : BaseException(LaailaErrors.NOT_PERMITTED_OPERATION, message)