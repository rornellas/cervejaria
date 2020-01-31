package br.com.fiap.cervejaria.repository

import br.com.fiap.cervejaria.dto.TipoEnum
import br.com.fiap.cervejaria.entity.Cerveja
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CervejaRepository: JpaRepository<Cerveja, Int> {

    @Query("from Cerveja where (:tipo is null or tipo = :tipo)")
    fun findAllByTipo(tipo: TipoEnum?, pageable: Pageable): List<Cerveja>

}