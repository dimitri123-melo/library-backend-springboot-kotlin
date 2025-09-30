package com.example.connect

import jakarta.persistence.*

@Entity
@Table(name = "register")
data class Register(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var name: String = "",
    var email: String = "",
    var password: String = "",
    var cpassword: String = "",
    var role: String = "",
)






