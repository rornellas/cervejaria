package br.com.fiap.cervejaria.service.impl

import br.com.fiap.cervejaria.dto.TipoEnum
import br.com.fiap.cervejaria.service.CervejaService
import org.springframework.stereotype.Service
import br.com.fiap.cervejaria.dto.PrecoCervejaDTO
import br.com.fiap.cervejaria.dto.CreateCervejaDTO

import br.com.fiap.cervejaria.dto.CervejaDTO
import br.com.fiap.cervejaria.entity.Cerveja
import br.com.fiap.cervejaria.repository.CervejaRepository
import org.springframework.data.domain.Pageable
import kotlin.streams.toList


@Service
class CervejaServiceImpl(val repository: CervejaRepository) : CervejaService {

    override fun findAll(tipo: TipoEnum?): List<CervejaDTO> {
        return repository.findAllByTipo(tipo, Pageable.unpaged()).stream().map { CervejaDTO(it) }.toList()
    }

    override fun findById(id: Int): CervejaDTO? {
        return CervejaDTO(repository.findById(id).get())
    }

    override fun create(createCervejaDTO: CreateCervejaDTO): CervejaDTO {
        val cerveja = Cerveja(createCervejaDTO)

        val save = this.repository.save(cerveja)

        return CervejaDTO(save)
    }

    override fun update(id: Int?, createCervejaDTO: CreateCervejaDTO?): CervejaDTO? {
        return null
    }

    override fun update(id: Int?, precoCervejaDTO: PrecoCervejaDTO?): CervejaDTO? {
        return null
    }

    override fun delete(id: Int?) {

    }
}
