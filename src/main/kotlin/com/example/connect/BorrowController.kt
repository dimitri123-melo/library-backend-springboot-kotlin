package com.example.connect


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


import org.springframework.web.bind.annotation.*


@RestController

@RequestMapping("/api/borrow")
class BorrowController (val borrowRepository: BorrowRepository) {
    @GetMapping
    fun getAllBorrow(): List<Borrow> = borrowRepository.findAll()
    @PostMapping
    fun createBorrow(@RequestBody borrow: Borrow): Borrow = borrowRepository.save(borrow)


//    @PutMapping("/{id}")
//    fun updateBook(@PathVariable id: Long, @RequestBody updated: Book): Book {
//        val book = bookRepository.findById(id).orElseThrow { RuntimeException("Book not found") }
//        book.image = updated.image
//        book.name = updated.name
//        book.author = updated.author
//        return bookRepository.save(book)
//    }


    @DeleteMapping("/{id}")
    fun deleteBorrow(@PathVariable id: Long) = borrowRepository.deleteById(id)


}