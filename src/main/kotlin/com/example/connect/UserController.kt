package com.example.connect

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


import org.springframework.web.bind.annotation.*

@RestController

// The Registration Form
@RequestMapping("/api/register")
class UserController(private val userRepository: UserRepository) {
    @GetMapping
    fun getAllUser(): List<Register> = userRepository.findAll()
    @PostMapping
    fun createUser(@RequestBody user: Register): Register = userRepository.save(user)


//    @PutMapping("/{id}")
//    fun updateUser(@PathVariable id: Long, @RequestBody updated: User): User {
//        val user = userRepository.findById(id).orElseThrow { RuntimeException("User not found") }
//        user.name = updated.name
//        user.email = updated.email
//        user.password = updated.password
//        user.cpassword = updated.cpassword
//        user.role = updated.role
//        return userRepository.save(user)
// }
    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) = userRepository.deleteById(id)
}


