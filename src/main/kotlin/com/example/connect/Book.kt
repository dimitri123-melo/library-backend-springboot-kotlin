package com.example.connect

import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name = "book")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var name: String = "",
    var author: String = "",

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    var image: ByteArray? = null,

//    var createdAt: LocalDateTime = LocalDateTime.now()
)