package com.example.connect

import jakarta.persistence.*


@Entity
@Table(name = "issue")
data class Issue(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long = 0,
    val book: String = "",
    val author: String = "",
    val member: String = ""
)