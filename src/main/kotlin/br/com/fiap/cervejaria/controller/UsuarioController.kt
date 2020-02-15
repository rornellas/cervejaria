package br.com.fiap.cervejaria.controller

import br.com.fiap.cervejaria.dto.AuthDTO
import br.com.fiap.cervejaria.dto.CreateUserDTO
import br.com.fiap.cervejaria.dto.JwtDTO
import br.com.fiap.cervejaria.dto.UserDTO
import br.com.fiap.cervejaria.service.UsuarioService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("usuario")
class UsuarioController(val service: UsuarioService) {

    @PostMapping
    fun criar(usuario: CreateUserDTO) {
        service.create(usuario)
    }

    @PostMapping("login")
    fun login(@RequestBody authDTO: AuthDTO): JwtDTO {
        return service.login(authDTO)
    }

}