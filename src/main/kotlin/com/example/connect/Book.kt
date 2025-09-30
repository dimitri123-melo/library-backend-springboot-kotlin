package com.example.connect

import jakarta.persistence.*


@Entity
@Table(name = "book")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var name: String = "",
    var author: String = "",

//    @Lob
//    @Column(name = "profile_image", columnDefinition = "LONGBLOB")
//    var image: ByteArray? = null
)