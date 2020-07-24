package com.br.laaila.reservas.laailareservas.infrastructure.repository

import com.br.laaila.reservas.laailareservas.model.entity.Permissao
import org.springframework.data.jpa.repository.JpaRepository

interface PermissaoRepositoy : JpaRepository<Permissao, Long>