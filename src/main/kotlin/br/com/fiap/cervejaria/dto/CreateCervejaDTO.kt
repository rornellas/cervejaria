package br.com.fiap.cervejaria.dto

import java.math.BigDecimal
import java.time.ZonedDateTime

data class CreateCervejaDTO(
        var marca: String,
        val teorAlcoolico: Double,
        val tipo: TipoEnum,
        val preco: BigDecimal,
        val dataLancamento: ZonedDateTime
)