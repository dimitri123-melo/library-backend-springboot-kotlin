package com.example.connect


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReserveBookRepository : JpaRepository<ReserveBook, Long>

