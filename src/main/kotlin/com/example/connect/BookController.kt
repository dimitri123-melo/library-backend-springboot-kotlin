package com.example.connect

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity
import org.springframework.web.multipart.MultipartFile
@RestController

@RequestMapping("/api/book")
class BookController(val bookRepository: BookRepository) {
    @GetMapping
    fun getAllBook(): List<Book> = bookRepository.findAll()


    @PostMapping
    fun createBook(@RequestBody book: Book): Book = bookRepository.save(book)

    @PutMapping("/{id}")
    fun updateBook(@PathVariable id: Long, @RequestBody updated: Book): Book {
        val book = bookRepository.findById(id).orElseThrow { RuntimeException("Book not found") }
//        book.image = updated.image
        book.name = updated.name
        book.author = updated.author
        return bookRepository.save(book)
    }


    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) = bookRepository.deleteById(id)


}