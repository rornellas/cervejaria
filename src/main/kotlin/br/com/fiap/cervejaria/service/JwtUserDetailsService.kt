package br.com.fiap.cervejaria.service

import br.com.fiap.cervejaria.repository.UsuarioRepository
import io.reactivex.Single
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.ArrayList


@Service
class JwtUserDetailsService(private val usuarioRepository: UsuarioRepository) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = usuarioRepository.findFirstByUsername(username)
                ?: throw UsernameNotFoundException(String.format("Username not found %s", username))

        return User(
            user.username,
            user.password,
            ArrayList()
        )
    }
}