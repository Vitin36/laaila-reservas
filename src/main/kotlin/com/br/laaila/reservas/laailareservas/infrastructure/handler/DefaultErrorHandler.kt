package com.br.laaila.reservas.laailareservas.infrastructure.handler

import com.br.laaila.reservas.laailareservas.infrastructure.exception.BaseExceptionMessage
import com.br.laaila.reservas.laailareservas.infrastructure.exception.DependentEntityNotFound
import com.br.laaila.reservas.laailareservas.infrastructure.exception.NotFoundException
import com.br.laaila.reservas.laailareservas.infrastructure.exception.NotPermittedOperationException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class DefaultErrorHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(ex: NotFoundException) =
            BaseExceptionMessage(message = ex.message, code = ex.code)

    @ExceptionHandler(DependentEntityNotFound::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleDependentEntityNotFound(ex: DependentEntityNotFound) =
            BaseExceptionMessage(message = ex.message, code = ex.code)

    @ExceptionHandler(NotPermittedOperationException::class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    fun handleNotPermittedOperation(ex: NotPermittedOperationException) =
            BaseExceptionMessage(message = ex.message, code = ex.code)

//    @ExceptionHandler(MethodArgumentNotValidException::class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    fun handleArgumentNotValid(ex: MethodArgumentNotValidException) = ValidationError(ex.bindingResult.fieldErrors
//            .stream()
//            .map { FieldError(it.field, it.defaultMessage) }
//            .toList()
//            .distinct())
}
