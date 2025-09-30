package com.example.connect

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "reservebook")
data class ReserveBook(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name:String = "",
    val author: String = "",
    val reservedate: LocalDate
)