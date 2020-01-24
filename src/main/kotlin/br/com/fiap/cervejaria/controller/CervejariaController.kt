package br.com.fiap.cervejaria.controller

import br.com.fiap.cervejaria.dto.CervejaDTO
import br.com.fiap.cervejaria.dto.CreateCervejaDTO
import br.com.fiap.cervejaria.dto.PrecoCervejaDTO
import br.com.fiap.cervejaria.dto.TipoEnum
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
class CervejariaController {

    var cervejaDTOList: ArrayList<CervejaDTO> = ArrayList()

    init {
        cervejaDTOList.add(
                CervejaDTO(
                        id = Integer(1),
                        marca = "Colorado Ribeirão Lagger",
                        teorAlcoolico = 5.0,
                        tipo = TipoEnum.LAGGER,
                        preco = BigDecimal(9.0),
                        dataLancamento = ZonedDateTime.now().minusYears(1)))

        cervejaDTOList.add(
                CervejaDTO(
                        id = Integer(2),
                        marca = "Black Princess",
                        teorAlcoolico = 6.3,
                        tipo = TipoEnum.IPA,
                        preco = BigDecimal(13.0),
                        dataLancamento = ZonedDateTime.now().minusYears(8)))

        cervejaDTOList.add(
                CervejaDTO(
                        id = Integer(3),
                        marca = "Paulaner",
                        teorAlcoolico = 5.0,
                        tipo = TipoEnum.WEISS,
                        preco = BigDecimal(16.0),
                        dataLancamento = ZonedDateTime.now().minusYears(50)))
    }

    @GetMapping
    fun listarCervejas(@RequestParam(name = "tipo", required = false) tipo: String?): List<CervejaDTO>? {
        return cervejaDTOList.stream().filter { it.tipo.equals(tipo) || tipo == null }?.toList()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Integer): CervejaDTO {
        return cervejaDTOList.stream().filter { it.id!!.equals(id) }.findFirst().orElseThrow() { ResponseStatusException(HttpStatus.NOT_FOUND) }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criarCerveja(@Valid @RequestBody createCerveja: CreateCervejaDTO) : CervejaDTO {
        val criado = CervejaDTO(createCerveja, Integer(cervejaDTOList.size + 1))
        cervejaDTOList.add(criado)
        return criado
    }

    @PutMapping("{id}")
    fun atualizarCerveja(@PathVariable("id") id: Integer, @RequestBody createCerveja: CreateCervejaDTO) : CervejaDTO {
        val obj = findById(id)

        obj.marca = createCerveja.marca
        obj.dataLancamento = createCerveja.dataLancamento
        obj.preco = createCerveja.preco
        obj.teorAlcoolico = createCerveja.teorAlcoolico
        obj.tipo = createCerveja.tipo

        return obj
    }

    @PatchMapping("{id}")
    fun patchCerveja(@PathVariable("id") id: Integer, @RequestBody precoCervejaDTO: PrecoCervejaDTO) : CervejaDTO {
        val obj = findById(id)

        obj.preco = precoCervejaDTO.preco

        return obj
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable("id") id: Integer): CervejaDTO {
        val findById = findById(id)

        cervejaDTOList.remove(findById)

        return findById;
    }
}