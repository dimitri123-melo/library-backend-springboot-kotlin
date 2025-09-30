package com.example.connect

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


import org.springframework.web.bind.annotation.*



@RestController
@RequestMapping("api/requestBook")
data class RequestBookController(private val requestBookRepository: RequestBookRepository){
    @GetMapping
    fun getAllRequest(): List<RequestBook> = requestBookRepository.findAll()

    @PostMapping
    fun createRequest(@RequestBody requestBook: RequestBook): RequestBook = requestBookRepository.save(requestBook)

    @DeleteMapping("/{id}")
    fun deleteRequest(@PathVariable id: Long) = requestBookRepository.deleteById(id)
}

