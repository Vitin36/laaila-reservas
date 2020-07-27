package com.br.laaila.reservas.laailareservas.infrastructure.repository

import com.br.laaila.reservas.laailareservas.model.entity.Carrinho
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CarrinhoRepository : JpaRepository<Carrinho, Long>{
    fun findByUsuario_Id(id: Long): Optional<Carrinho>
}