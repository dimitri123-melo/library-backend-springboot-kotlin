package com.example.connect

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


import org.springframework.web.bind.annotation.*


@RestController

@RequestMapping("/api/renew")
class RenewController (private val renewRepository: RenewRepository) {
    @GetMapping
    fun getAllRenew(): List<Renew> = renewRepository.findAll()
    @PostMapping
    fun createRenew(@RequestBody renew: Renew): Renew = renewRepository.save(renew)


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
    fun deleteUser(@PathVariable id: Long) = renewRepository.deleteById(id)
}