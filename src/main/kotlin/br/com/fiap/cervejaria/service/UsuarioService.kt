package br.com.fiap.cervejaria.service

import br.com.fiap.cervejaria.dto.AuthDTO
import br.com.fiap.cervejaria.dto.CreateUserDTO
import br.com.fiap.cervejaria.dto.JwtDTO
import br.com.fiap.cervejaria.dto.UserDTO

interface UsuarioService {

    fun create(createUser: CreateUserDTO): UserDTO?
    fun login(authDTO: AuthDTO): JwtDTO
}
