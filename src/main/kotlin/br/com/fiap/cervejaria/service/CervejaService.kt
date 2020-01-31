package br.com.fiap.cervejaria.service;

import br.com.fiap.cervejaria.dto.PrecoCervejaDTO
import br.com.fiap.cervejaria.dto.CervejaDTO
import br.com.fiap.cervejaria.dto.CreateCervejaDTO
import br.com.fiap.cervejaria.dto.TipoEnum


interface CervejaService {
    fun findAll(tipo: TipoEnum?): List<CervejaDTO>?
    fun findById(id: Int): CervejaDTO?
    fun create(createCervejaDTO: CreateCervejaDTO): CervejaDTO
    fun update(id: Int?, createCervejaDTO: CreateCervejaDTO?): CervejaDTO?
    fun update(id: Int?, precoCervejaDTO: PrecoCervejaDTO?): CervejaDTO?
    fun delete(id: Int?)
}

