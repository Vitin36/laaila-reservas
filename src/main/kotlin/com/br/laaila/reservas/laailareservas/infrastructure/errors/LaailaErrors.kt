package com.br.laaila.reservas.laailareservas.infrastructure.errors

object LaailaErrors {
    val UNKNOWN_ERROR = ErrorCode("001", "Erro desconhecido")
    val INTERNAL_ERROR = ErrorCode("002", "Erro interno")
    val VALIDATION_ERROR = ErrorCode("002", "Erro na validação do objeto")
    val NOT_FOUND_ERROR = ErrorCode("003", "Entidade não encontrada")
}