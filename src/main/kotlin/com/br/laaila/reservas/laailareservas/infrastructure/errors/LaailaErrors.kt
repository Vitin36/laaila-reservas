package com.br.laaila.reservas.laailareservas.infrastructure.errors

object LaailaErrors {
    val UNKNOWN_ERROR = ErrorCode("001", "Erro desconhecido")
    val INTERNAL_ERROR = ErrorCode("002", "Erro interno")
    val VALIDATION_ERROR = ErrorCode("002", "Erro na validação do objeto")
    val NOT_FOUND_ERROR = ErrorCode("003", "Entidade não encontrada")
    val DEPENDENT_ENTITY_NOT_FOUND = ErrorCode("004", "Entidade dependente não encontrada")
    val NOT_PERMITTED_OPERATION = ErrorCode("005", "Operação não permitida")
}