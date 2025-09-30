package com.example.connect

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "requestbook")
data class RequestBook(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long = 0,
    val name: String = "",
    val author:String = "",
    val requestdate : LocalDate
)