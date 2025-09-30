package com.example.connect



import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RequestBookRepository : JpaRepository<RequestBook, Long>

