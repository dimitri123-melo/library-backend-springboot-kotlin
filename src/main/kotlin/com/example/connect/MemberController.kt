package com.example.connect

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


import org.springframework.web.bind.annotation.*


@RestController

@RequestMapping("/api/member")
class MemberController (private val memberRepository: MemberRepository) {
    @GetMapping
    fun getAllMember(): List<Member> = memberRepository.findAll()
    @PostMapping
    fun createMember(@RequestBody member: Member): Member = memberRepository.save(member)


        @PutMapping("/{id}")
    fun updateMember(@PathVariable id: Long, @RequestBody updated: Member): Member {
        val member = memberRepository.findById(id).orElseThrow { RuntimeException("Member not found") }
        member.name = updated.name
        member.email = updated.email
        member.member = updated.member
        return memberRepository.save(member)
 }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) = memberRepository.deleteById(id)
}