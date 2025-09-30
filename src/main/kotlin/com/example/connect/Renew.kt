package com.example.connect

import jakarta.persistence.*


@Entity
@Table(name =  "renew")
data class Renew(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long = 0,
    var book_name:String ="",
    var status:String = "",
)