package com.example.connect

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/issue")
data class IssueController(val issueRepository: IssueRepository){

    @GetMapping
    fun getAllIssue(): List<Issue> = issueRepository.findAll()

    @PostMapping
    fun createIssue(@RequestBody issue: Issue): Issue = issueRepository.save(issue)

    @DeleteMapping("/{id}")
    fun deleteIssue(@PathVariable id: Long) = issueRepository.deleteById(id)


}