package br.com.fiap.cervejaria.dto

import java.math.BigDecimal
import java.time.ZonedDateTime
import javax.validation.constraints.Min

data class CervejaDTO(
        var id: Integer,
        var marca: String,
        var teorAlcoolico: Double,
        var tipo: TipoEnum,
        var preco: BigDecimal,
        var dataLancamento: ZonedDateTime
) {
    constructor(
            cervejaDTO: CreateCervejaDTO,
            id: Integer
    ) : this(
            id = id,
            marca = cervejaDTO.marca,
            teorAlcoolico = cervejaDTO.teorAlcoolico,
            tipo = cervejaDTO.tipo,
            preco = cervejaDTO.preco,
            dataLancamento = cervejaDTO.dataLancamento
    )
}