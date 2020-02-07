package br.com.fiap.cervejaria.dto

import br.com.fiap.cervejaria.entity.Usuario
import java.time.ZonedDateTime

data class UserDTO(
        var username: String,
        var password: String,
        var dataCriacao: ZonedDateTime?,
        var dataModificacao: ZonedDateTime?
) {
    constructor(createUser: Usuario) : this(
        username = createUser.username!!,
        password = createUser.password!!,
        dataCriacao = null,
        dataModificacao = null
    )
}
