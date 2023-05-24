package com.kotlin.coroutine.kotlincoroutine

import kotlinx.coroutines.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class CoroutinesTest {

    @Test
    fun testGetDataFromApi() = runBlocking {
        // Cria um escopo de teste
        val testScope = CoroutineScope(Dispatchers.Default)

        // Chama a função assíncrona dentro do escopo de teste
        val result = testScope.async {
            getDataFromApi()
        }

        // Aguarda a conclusão da coroutine
        val data = result.await()

        // Verifica o resultado
        assertEquals("Dados esperados", data)
    }

    suspend fun getDataFromApi(): String {
        // Simula uma chamada assíncrona à API
        delay(1000)
        return "Dados esperados"
    }
}