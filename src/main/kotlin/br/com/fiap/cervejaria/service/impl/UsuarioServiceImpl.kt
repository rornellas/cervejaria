package br.com.fiap.cervejaria.service.impl

import br.com.fiap.cervejaria.service.CervejaService
import org.springframework.stereotype.Service

import br.com.fiap.cervejaria.dto.CreateUserDTO
import br.com.fiap.cervejaria.dto.UserDTO
import br.com.fiap.cervejaria.entity.Usuario

import br.com.fiap.cervejaria.repository.UsuarioRepository
import br.com.fiap.cervejaria.service.UsuarioService


@Service
class UsuarioServiceImpl(val repository: UsuarioRepository) : UsuarioService {

    override  fun create(createUser: CreateUserDTO): UserDTO? {
        val user = Usuario(createUser)

        repository.save(user)

        return UserDTO(user)
    }

}
