package com.example.homework_1.repository

import com.example.homework_1.model.FilmModel

class DataRepository {
    var filmsList: List<FilmModel> = emptyList()

    fun saveFilms(films: List<FilmModel>) {
        filmsList = films
    }

    fun getFilms(): List<FilmModel> {
        return filmsList
    }
}