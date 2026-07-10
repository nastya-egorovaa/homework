package com.example.homework_1.model

data class FilmModel(
    val id: String,
    val posterUrl: String,
    val name: String,
    val description: String?,
    val releaseDate: Int
)
