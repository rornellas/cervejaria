package br.com.fiap.cervejaria.entity

import br.com.fiap.cervejaria.dto.CreateUserDTO
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "TB_USUARIO")
@EntityListeners(AuditingEntityListener::class)
data class Usuario(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Integer? = null,
        @Column
        var username: String? = null,
        @Column
        var password: String? = null,
        @Column
        @CreatedDate
        var dataCriacao: Date? = null,
        @Column
        @LastModifiedDate
        var dataModificacao: Date? = null
) {
        constructor(createUser: CreateUserDTO) : this(
                id = null,
                username = createUser.username,
                password = createUser.password,
                dataCriacao = null,
                dataModificacao = null
        )
}