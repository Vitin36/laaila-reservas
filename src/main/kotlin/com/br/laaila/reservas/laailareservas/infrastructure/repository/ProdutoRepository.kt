package com.br.laaila.reservas.laailareservas.infrastructure.repository

import com.br.laaila.reservas.laailareservas.model.entity.Produto
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProdutoRepository: JpaRepository<Produto, UUID>