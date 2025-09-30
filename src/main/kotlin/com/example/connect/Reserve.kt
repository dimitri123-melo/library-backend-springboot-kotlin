package com.example.connect

import jakarta.persistence.*

@Entity
@Table(name = "reserve")
data class Reserve(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var book_name: String = "",
    var member_name: String = ""
)