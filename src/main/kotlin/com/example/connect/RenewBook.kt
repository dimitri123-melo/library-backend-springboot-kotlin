package com.example.connect

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "renewbook")
data class RenewBook(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String = "",
    val author:String = "",
    val renewdate: LocalDate
)