package br.com.fiap.cervejaria.entity

import br.com.fiap.cervejaria.dto.CreateCervejaDTO
import br.com.fiap.cervejaria.dto.TipoEnum
import org.springframework.boot.autoconfigure.domain.EntityScan
import java.math.BigDecimal
import java.time.ZonedDateTime
import javax.persistence.*

@Entity
@Table(name = "TB_CERVEJA")
data class Cerveja(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Int?,
    @Column(name = "MARCA")
    var marca: String?,
    @Column(name = "TEOR_ALCOOLICO")
    var teorAlcoolico: Double?,
    @Column(name = "TIPO")
    var tipo: TipoEnum?,
    @Column(name = "PRECO")
    var preco: BigDecimal?,
    @Column(name = "DATA_LANCAMENTO")
    var dataLancamento: ZonedDateTime?
) {
    constructor(it: CreateCervejaDTO) : this(
        id = null,
        marca = it.marca,
        teorAlcoolico = it.teorAlcoolico,
        tipo = it.tipo,
        preco = it.preco,
        dataLancamento = it.dataLancamento
    )

    constructor(): this(
        id = null,
        marca = null,
        teorAlcoolico = null,
        tipo = null,
        preco = null,
        dataLancamento = null
    )
}