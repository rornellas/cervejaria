package br.com.fiap.cervejaria.controller

import br.com.fiap.cervejaria.dto.CervejaDTO
import br.com.fiap.cervejaria.dto.CreateCervejaDTO
import br.com.fiap.cervejaria.dto.PrecoCervejaDTO
import br.com.fiap.cervejaria.dto.TipoEnum
import br.com.fiap.cervejaria.repository.CervejaRepository
import br.com.fiap.cervejaria.service.CervejaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.math.BigDecimal
import java.time.ZonedDateTime
import java.util.*
import javax.validation.Valid
import kotlin.streams.toList

@RestController
@RequestMapping("cerveja")
class CervejariaController(val service: CervejaService) {

    @GetMapping
    fun listarCervejas(@RequestParam(name = "tipo", required = false) tipo: TipoEnum?): List<CervejaDTO>? {
        return this.service.findAll(tipo)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Int): CervejaDTO? {
        return this.service.findById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criarCerveja(@Valid @RequestBody createCerveja: CreateCervejaDTO) : CervejaDTO {
        return this.service.create(createCerveja)
    }

    @PutMapping("{id}")
    fun atualizarCerveja(@PathVariable("id") id: Int, @RequestBody createCerveja: CreateCervejaDTO?) : CervejaDTO? {
        return this.service.update(id, createCerveja)
    }

    @PatchMapping("{id}")
    fun patchCerveja(@PathVariable("id") id: Int, @RequestBody precoCervejaDTO: PrecoCervejaDTO) : CervejaDTO? {
        val obj = findById(id)

        obj?.preco = precoCervejaDTO.preco

        return obj
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable("id") id: Int) {
        this.service.delete(id)
    }
}