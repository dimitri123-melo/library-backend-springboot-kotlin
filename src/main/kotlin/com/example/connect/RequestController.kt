package com.example.connect


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


import org.springframework.web.bind.annotation.*


@RestController

@RequestMapping("/api/request")
class RequestController (private val requestRepository: RequestRepository) {
    @GetMapping
    fun getAllRequest(): List<Request> = requestRepository.findAll()
    @PostMapping
    fun createRequest(@RequestBody request: Request): Request = requestRepository.save(request)


        @PutMapping("/{id}")
    fun updateRequest(@PathVariable id: Long, @RequestBody updated: Request): Request {
        val request = requestRepository.findById(id).orElseThrow { RuntimeException("Request not found") }
        request.member_name = updated.member_name
        request.book_name = updated.book_name
        return requestRepository.save(request)
 }


    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) = requestRepository.deleteById(id)
}