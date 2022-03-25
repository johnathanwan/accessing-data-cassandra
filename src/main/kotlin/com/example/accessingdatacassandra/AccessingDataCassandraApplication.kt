package com.example.accessingdatacassandra

import mu.*
import org.springframework.boot.*
import org.springframework.boot.autoconfigure.*
import org.springframework.context.annotation.*
import java.util.*

@SpringBootApplication
class AccessingDataCassandraApplication {
    companion object {
        private val logger = KotlinLogging.logger {}
    }

    @Bean
    fun clr(vetRepository: VetRepository): CommandLineRunner {
        return CommandLineRunner {
            vetRepository.deleteAll()

            val john = Vet(UUID.randomUUID(), "John", "Doe", setOf("surgery"))
            val jane = Vet(UUID.randomUUID(), "Jane", "Doe", setOf("radiology", "surgery"))

            val savedJohn = vetRepository.save(john)
            @Suppress("UNUSED_VARIABLE")
            val savedJane = vetRepository.save(jane)

            vetRepository.findAll().forEach { logger.info("Vet: ${it.firstName}") }
            vetRepository.findById(savedJohn.id).ifPresent { logger.info ("Vet by id: ${it.firstName}") }
        }
    }
}

fun main(args: Array<String>) {
    runApplication<AccessingDataCassandraApplication>(*args)
}
