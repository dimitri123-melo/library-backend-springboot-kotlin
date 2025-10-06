package com.example.connect




import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.util.*

@RestController
@RequestMapping("/api/book")
class BookController(val bookRepository: BookRepository) {

    // GET all books safely
    @GetMapping
    fun getAllBooks(): List<BookResponse> {
        return bookRepository.findAll().map { book ->
            val base64Image = book.image?.let { img ->
                try {
                    Base64.getEncoder().encodeToString(img)
                } catch (e: Exception) {
                    println("Error encoding image for book ${book.id}: ${e.message}")
                    null
                }
            }
            BookResponse(
                id = book.id,
                name = book.name,
                author = book.author,
                imageBase64 = base64Image
            )
        }
    }

    // POST upload new book
    @PostMapping("/upload")
    fun createBook(
        @RequestParam name: String,
        @RequestParam author: String,
        @RequestParam("image") file: MultipartFile
    ): ResponseEntity<BookResponse> {
        try {
            println("Received file: ${file.originalFilename}, size: ${file.size}")
            val book = Book(name = name, author = author, image = file.bytes)
            val saved = bookRepository.save(book)
            val base64Image = saved.image?.let { Base64.getEncoder().encodeToString(it) }
            return ResponseEntity.ok(BookResponse(saved.id, saved.name, saved.author, base64Image))
        } catch (e: Exception) {
            e.printStackTrace() // This will show the exact error in console
            throw e
        }
    }


    // DELETE a book (optional)
    @DeleteMapping("/{id}")
    fun deleteBook(@PathVariable id: Long) = bookRepository.deleteById(id)

    // PUT update book (optional)
    @PutMapping("/{id}")
    fun updateBook(
        @PathVariable id: Long,
        @RequestParam name: String,
        @RequestParam author: String,
        @RequestParam("image", required = false) file: MultipartFile?
    ): ResponseEntity<BookResponse> {
        val book = bookRepository.findById(id).orElseThrow { RuntimeException("Book not found") }

        book.name = name
        book.author = author
        if (file != null) book.image = file.bytes

        val saved = bookRepository.save(book)

        val base64Image = saved.image?.let { Base64.getEncoder().encodeToString(it) }

        return ResponseEntity.ok(
            BookResponse(
                id = saved.id,
                name = saved.name,
                author = saved.author,
                imageBase64 = base64Image
            )
        )
    }
}









//import org.springframework.http.MediaType
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.RestController
//
//
//import org.springframework.web.bind.annotation.*
//import org.springframework.http.ResponseEntity
//import org.springframework.web.multipart.MultipartFile
//@RestController
//
//@RequestMapping("/api/book")
//class BookController(val bookRepository: BookRepository) {
//    @GetMapping
//    fun getAllBook(): List<Book> = bookRepository.findAll()
//
//
//    @PostMapping
//    fun createBook(@RequestBody book: Book): Book = bookRepository.save(book)
//
//    @PutMapping("/{id}")
//    fun updateBook(@PathVariable id: Long, @RequestBody updated: Book): Book {
//        val book = bookRepository.findById(id).orElseThrow { RuntimeException("Book not found") }
//        book.image = updated.image
//        book.name = updated.name
//        book.author = updated.author
//        return bookRepository.save(book)
//    }
//
//
//    @DeleteMapping("/{id}")
//    fun deleteUser(@PathVariable id: Long) = bookRepository.deleteById(id)
//
//
//}