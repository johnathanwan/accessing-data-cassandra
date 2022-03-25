package com.example.accessingdatacassandra

import org.springframework.data.repository.CrudRepository
import java.util.UUID

@Suppress("unused")
interface VetRepository : CrudRepository<Vet, UUID> {
    fun findByFirstName(username: String): Vet
}