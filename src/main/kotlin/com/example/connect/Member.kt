package com.example.connect

import jakarta.persistence.*

@Entity
@Table(name = "member")
data class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    var id: Long = 0,
    var name:String = "",
    var email:String = "",
    var member:String = ""

)