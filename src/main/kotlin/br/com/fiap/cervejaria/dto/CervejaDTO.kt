package br.com.fiap.cervejaria.dto

import br.com.fiap.cervejaria.entity.Cerveja
import java.math.BigDecimal
import java.time.ZonedDateTime
import java.time.ZoneOffset


data class CervejaDTO(
        var id: Int?,
        var marca: String?,
        var teorAlcoolico: Double?,
        var tipo: TipoEnum?,
        var preco: BigDecimal?,
        var dataCriacao: ZonedDateTime?,
        var dataModificacao: ZonedDateTime?
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
            dataCriacao = convertToZonedDateTime(cervejaDTO.dataCriacao),
            dataModificacao = convertToZonedDateTime(cervejaDTO.dataModificacao)
    )

    constructor(it: Cerveja) : this(
            id = it.id,
            marca = it.marca,
            teorAlcoolico = it.teorAlcoolico,
            tipo = it.tipo,
            preco = it.preco,
            dataCriacao = it.dataCriacao,
            dataModificacao = it.dataModificacao
    )


}
private fun convertToZonedDateTime(dataModificacao: ZonedDateTime?): ZonedDateTime? {
    if (dataModificacao != null) {
        return ZonedDateTime.ofInstant(dataModificacao!!.toInstant(), ZoneOffset.systemDefault())
    }
    return null
}