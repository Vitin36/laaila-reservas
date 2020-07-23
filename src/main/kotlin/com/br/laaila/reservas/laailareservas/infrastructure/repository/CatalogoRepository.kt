package com.br.laaila.reservas.laailareservas.infrastructure.repository

import com.br.laaila.reservas.laailareservas.model.entity.Catalogo
import org.springframework.data.jpa.repository.JpaRepository

interface CatalogoRepository : JpaRepository<Catalogo, Long>