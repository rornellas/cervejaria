package br.com.fiap.cervejaria.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
class WebSecurityConfig: WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.inMemoryAuthentication()
                .withUser("admin").password("{noop}adminsenha").roles("ADMIN", "USER")
            .and()
                .withUser("euzinho").password("{noop}euzinho").roles("USER")
    }

    override fun configure(http: HttpSecurity?) {
        http!!.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "cervejas").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable()
    }

}