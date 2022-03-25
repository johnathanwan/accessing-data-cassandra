package com.example.accessingdatacassandra

import org.springframework.data.cassandra.core.mapping.*
import java.util.UUID

@Suppress("unused")
@Table
class Vet(@field:PrimaryKey var id: UUID, var firstName: String, var lastName: String, var specialties: Set<String>)