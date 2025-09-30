package com.example.connect

import jakarta.persistence.*
import java.time.LocalDate


@Entity
@Table(name = "borrow")
data class Borrow(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var name: String = "",
    var author: String = "",
    val borrowdate: LocalDate
)