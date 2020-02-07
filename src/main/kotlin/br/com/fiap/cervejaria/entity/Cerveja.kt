package br.com.fiap.cervejaria.entity

import br.com.fiap.cervejaria.dto.CreateCervejaDTO
import br.com.fiap.cervejaria.dto.TipoEnum
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.math.BigDecimal
import java.time.ZonedDateTime
import javax.persistence.*

@Entity
@Table(name = "TB_CERVEJA")
@EntityListeners(AuditingEntityListener::class)
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
    @Enumerated(EnumType.STRING)
    var tipo: TipoEnum?,
    @Column(name = "PRECO")
    var preco: BigDecimal?,
    @Column(name = "DATA_CRIACAO", updatable = false, insertable = false)
    @CreatedDate
    var dataCriacao: ZonedDateTime?,
    @Column(name = "DATA_MODIFICACAO")
    @LastModifiedDate
    var dataModificacao: ZonedDateTime?
) {
    constructor(it: CreateCervejaDTO) : this(
        id = null,
        marca = it.marca,
        teorAlcoolico = it.teorAlcoolico,
        tipo = it.tipo,
        preco = it.preco,
        dataCriacao = it.dataCriacao,
        dataModificacao = it.dataModificacao
    )

    constructor(): this(
        id = null,
        marca = null,
        teorAlcoolico = null,
        tipo = null,
        preco = null,
        dataCriacao = null,
        dataModificacao = null
    )
}