package com.example.connect

import  org.springframework.web.bind.annotation.RestController
import  org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/reservebook")
data class ReserveBookController(private val reserveBookRepository: ReserveBookRepository){
    @GetMapping
    fun getAllReserveBook(): List<ReserveBook> = reserveBookRepository.findAll()

    @PostMapping
    fun createReserveBook(@RequestBody reserveBook: ReserveBook): ReserveBook = reserveBookRepository.save(reserveBook)


    @DeleteMapping("/{id}")
    fun deleteReserveBook(@PathVariable id: Long) = reserveBookRepository.deleteById(id)
}