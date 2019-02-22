package com.example

import com.example.models.Product
import com.example.models.ProductRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(private val prodRepository: ProductRepository) {
    @GetMapping("/products")
    fun getAllProducts(): List<Product> = prodRepository.findAll()

    @GetMapping("/products/{sku}")
    fun getProductBySku(@PathVariable(value = "sku") sku: String): ResponseEntity<Product> {
        return prodRepository.findById(sku).map {
            product -> ResponseEntity.ok(product)
        }.orElse(ResponseEntity.notFound().build())
    }
}