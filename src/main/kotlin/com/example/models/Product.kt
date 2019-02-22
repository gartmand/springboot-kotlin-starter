package com.example.models

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity @Table(name = "products")
data class Product(
    @Id @Size(min=1, max=63) val sku: String? = null,
    @NotBlank @Size(min=1, max=255) val description: String? = null
)

@Repository
interface ProductRepository : JpaRepository<Product, String>
