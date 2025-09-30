package com.example.connect


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


import org.springframework.web.bind.annotation.*


@RestController

@RequestMapping("/api/reserve")
class ReserveController (private val reserveRepository: ReserveRepository) {
    @GetMapping
    fun getAllReserve(): List<Reserve> = reserveRepository.findAll()
    @PostMapping
    fun createReserve(@RequestBody reserve: Reserve): Reserve = reserveRepository.save(reserve)


        @PutMapping("/{id}")
    fun updateReserve(@PathVariable id: Long, @RequestBody updated: Reserve): Reserve {
        val reserve = reserveRepository.findById(id).orElseThrow { RuntimeException("Reserve not found") }
        reserve.book_name = updated.book_name
        reserve.member_name = updated.member_name
        return reserveRepository.save(reserve)
 }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) = reserveRepository.deleteById(id)
}