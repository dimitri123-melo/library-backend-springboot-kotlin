package com.example.connect

import jakarta.persistence.*

@Entity
@Table(name = "request")
data class Request(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long  = 0,
    var member_name: String = "",
    var book_name: String = "",
    var response: String = ""
)