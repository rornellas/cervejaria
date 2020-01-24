package br.com.fiap.cervejaria

import br.com.fiap.cervejaria.controller.CervejariaController
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CervejaControllerUnitTest {

    @Test
    fun getAllTest() {
        val listarCervejas = CervejariaController().listarCervejas("weiss")
        Assertions.assertEquals(listarCervejas?.size, 1)
    }

}