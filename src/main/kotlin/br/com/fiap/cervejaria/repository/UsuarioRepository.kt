package br.com.fiap.cervejaria.repository

import br.com.fiap.cervejaria.dto.TipoEnum
import br.com.fiap.cervejaria.entity.Cerveja
import br.com.fiap.cervejaria.entity.Usuario
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Int> {

}