package com.example.connect

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/renewBook")
data class RenewBookController(private val renewBookRepository: RenewBookRepository){

    @GetMapping
    fun getAllRenewBooks(): List<RenewBook> = renewBookRepository.findAll()

    @PostMapping
    fun createRenewBook(@RequestBody renewBook: RenewBook): RenewBook = renewBookRepository.save(renewBook)

    @DeleteMapping("/{id}")
    fun deleteRenewBook(@PathVariable id: Long) = renewBookRepository.deleteById(id)
}