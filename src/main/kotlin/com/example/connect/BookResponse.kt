package com.example.connect


data class BookResponse(
    val id: Long,
    val name: String,
    val author: String,
    val imageBase64: String?
)
