package br.com.fiap.cervejaria.security

import br.com.fiap.cervejaria.service.JwtUserDetailsService
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException
import io.jsonwebtoken.ExpiredJwtException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource


@Component
class JwtRequestFilter(private val jwtTokenUtil: JwtTokenUtil,
                       private val jwtUserDetailsService: JwtUserDetailsService) : OncePerRequestFilter() {

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(request: HttpServletRequest,
                                  response: HttpServletResponse,
                                  filterChain: FilterChain) {

        val requestToken = request.getHeader("Authorization")

        var userName: String? = null

        if (requestToken != null && requestToken.startsWith("Bearer ")) {
            try {
                userName = jwtTokenUtil.getUsernameFromToken(requestToken)

            } catch (illegalArgumentException: IllegalArgumentException) {
                logger.info("Token inválido")
            } catch (expiredJwtException: ExpiredJwtException) {
                logger.info("Token expirado")
            }
        }

        if(userName != null && SecurityContextHolder.getContext().authentication == null) {
            val userDetails = jwtUserDetailsService.loadUserByUsername(userName)

            val auth: UsernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)

            auth.details = WebAuthenticationDetailsSource().buildDetails(request)
        }

        filterChain.doFilter(request, response)
    }
}