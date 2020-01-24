package br.com.fiap.cervejaria

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CervejariaApplication

fun main(args: Array<String>) {
	runApplication<CervejariaApplication>(*args)
}
