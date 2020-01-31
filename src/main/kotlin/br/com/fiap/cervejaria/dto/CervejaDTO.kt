package br.com.fiap.cervejaria.dto

import br.com.fiap.cervejaria.entity.Cerveja
import java.math.BigDecimal
import java.time.ZonedDateTime
import javax.validation.constraints.Min

data class CervejaDTO(
        var id: Int?,
        var marca: String?,
        var teorAlcoolico: Double?,
        var tipo: TipoEnum?,
        var preco: BigDecimal?,
        var dataLancamento: ZonedDateTime?
) {
    constructor(
            cervejaDTO: CreateCervejaDTO,
            id: Int
    ) : this(
            id = id,
            marca = cervejaDTO.marca,
            teorAlcoolico = cervejaDTO.teorAlcoolico,
            tipo = cervejaDTO.tipo,
            preco = cervejaDTO.preco,
            dataLancamento = cervejaDTO.dataLancamento
    )

    constructor(it: Cerveja) : this(
            id = it.id,
            marca = it.marca,
            teorAlcoolico = it.teorAlcoolico,
            tipo = it.tipo,
            preco = it.preco,
            dataLancamento = it.dataLancamento
    )
}