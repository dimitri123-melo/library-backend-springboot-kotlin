package com.example.connect

import jakarta.persistence.*

@Entity
@Table(name = "rules")
data class Rules(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long = 0,
    val title:String = "",
    val one:String = "",
    val two: String = "",
    val three: String = "",
    val four:String = "",
    val five:String = "",

)