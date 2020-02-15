package br.com.fiap.cervejaria.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.util.Date
import java.util.HashMap

@Component
class JwtTokenUtil {

    @Value("\${jwt.secret}")
    private val secret: String? = null

    @Value("\${jwt.expiration}")
    private val expire: Int = 0

    fun generateToken(username: String): String {
        val dataCriacao = getDateFromLocalDateTime(LocalDateTime.now())
        val dataExpiracao = getDateFromLocalDateTime(LocalDateTime.now().plusMinutes(expire.toLong()))
        return Jwts.builder()
                .setClaims(HashMap())
                .setSubject(username)
                .setIssuedAt(dataCriacao)
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact()
    }

    fun getUsernameFromToken(token: String): String {
        val claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token.replace("Bearer ", ""))
                .body
        return claims.subject
    }

    private fun getDateFromLocalDateTime(localDateTime: LocalDateTime): Date {
        return Date.from(localDateTime.toInstant(OffsetDateTime.now().offset))
    }

}