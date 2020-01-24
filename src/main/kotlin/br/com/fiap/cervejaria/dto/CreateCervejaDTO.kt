package br.com.fiap.cervejaria.dto

import java.math.BigDecimal
import java.time.ZonedDateTime
import javax.validation.constraints.Min

data class CreateCervejaDTO(
    var marca: String,
    @Min(5)var teorAlcoolico: Double,
    var tipo: TipoEnum,
    var preco: BigDecimal,
    var dataLancamento: ZonedDateTime
)