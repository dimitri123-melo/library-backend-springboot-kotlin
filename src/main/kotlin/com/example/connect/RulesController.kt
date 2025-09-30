package com.example.connect


import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/rules")
class RulesController(val rulesRepository: RulesRepository) {
    @GetMapping
    fun getAllRules(): List<Rules> = rulesRepository.findAll()


    @PostMapping
    fun createRule(@RequestBody rules: Rules): Rules = rulesRepository.save(rules)


    @DeleteMapping("/{id}")
    fun deleteRule(@PathVariable id: Long) = rulesRepository.deleteById(id)


}