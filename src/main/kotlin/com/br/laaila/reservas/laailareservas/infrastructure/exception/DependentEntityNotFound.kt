package com.br.laaila.reservas.laailareservas.infrastructure.exception

import com.br.laaila.reservas.laailareservas.infrastructure.errors.LaailaErrors

open class DependentEntityNotFound(override val message: String? = null) : BaseException(LaailaErrors.DEPENDENT_ENTITY_NOT_FOUND, message)