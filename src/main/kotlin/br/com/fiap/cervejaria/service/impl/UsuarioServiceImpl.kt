package br.com.fiap.cervejaria.service.impl

import br.com.fiap.cervejaria.dto.AuthDTO
import br.com.fiap.cervejaria.service.CervejaService
import org.springframework.stereotype.Service

import br.com.fiap.cervejaria.dto.CreateUserDTO
import br.com.fiap.cervejaria.dto.JwtDTO
import br.com.fiap.cervejaria.dto.UserDTO
import br.com.fiap.cervejaria.entity.Usuario

import br.com.fiap.cervejaria.repository.UsuarioRepository
import br.com.fiap.cervejaria.security.JwtTokenUtil
import br.com.fiap.cervejaria.service.UsuarioService
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.*
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.server.ResponseStatusException


@Service
class UsuarioServiceImpl(
    val repository: UsuarioRepository,
    val authenticationManager: AuthenticationManager,
    val jwtTokenUtil: JwtTokenUtil,
    val passwordEncoder: PasswordEncoder) : UsuarioService {

    override fun login(authDTO: AuthDTO): JwtDTO {
        try {
            val password = passwordEncoder.encode(authDTO.password);
            authenticationManager.authenticate(
                    UsernamePasswordAuthenticationToken(authDTO.username, password)
            )
        } catch (disabledException: DisabledException) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "user.disabled")
        } catch (badCredentialsException: BadCredentialsException) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid.credentials")
        }

        val token = jwtTokenUtil.generateToken(authDTO.username)

        return JwtDTO(token);
    }

    override fun create(createUser: CreateUserDTO): UserDTO? {
        val user = Usuario(createUser)
        user.password = passwordEncoder.encode(user.password)

        repository.save(user)

        return UserDTO(user)
    }

}
