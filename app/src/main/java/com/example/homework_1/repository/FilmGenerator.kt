package com.example.homework_1.repository

import com.example.homework_1.model.FilmModel

class FilmGenerator {

       private val filmDatabase = listOf(
            FilmModel(
                id = "1",
                posterUrl = "https://www.kino-teatr.ru/movie/poster/26166/203799.jpg",
                name = "Inception",
                description = "Сон в сознании",
                releaseDate = 2010
            ),
            FilmModel(
                id = "2",
                posterUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/1946459/332dd2eb-8e90-40f3-beae-4032ee931e27/1920x",
                name = "Shutter Island",
                description = "Остров проклятых",
                releaseDate = 2010
            ),
            FilmModel(
                id = "3",
                posterUrl = "https://avatars.mds.yandex.net/get-mpic/11760083/2a000001997ce463aac870bfc26c7dca7319/orig",
                name = "Interstellar",
                description = "Интерстеллар",
                releaseDate = 2014
            ),
            FilmModel(
                id = "4",
                posterUrl = "https://avatars.mds.yandex.net/i?id=49b7a95b58374c82a2e3019e0ff26304_l-5350134-images-thumbs&n=13",
                name = "Matrix",
                description = "Матрица",
                releaseDate = 1999
            ),
            FilmModel(
                id = "5",
                posterUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/1773646/899cb100-a91d-4120-95d3-3545ce082480/1920x",
                name = "Fight Club",
                description = "Бойцовский клуб",
                releaseDate = 1999
            ),
            FilmModel(
                id = "6",
                posterUrl = "https://ir.ozone.ru/s3/multimedia-s/6434920384.jpg",
                name = "Titanic",
                description = "Титаник",
                releaseDate = 1997
            ),
            FilmModel(
                id = "7",
                posterUrl = "https://n.cdn.cdek.shopping/images/shopping/VBqFt2mB5FyQLEkV.jpg?v=1",
                name = "Avatar",
                description = "Аватар",
                releaseDate = 2009
            ),
            FilmModel(
                id = "8",
                posterUrl = "https://ir.ozone.ru/s3/multimedia-g/6642514096.jpg",
                name = "Blood Diamond",
                description = "Кровавый алмаз",
                releaseDate = 2006
            )
       )

    fun generate(count: Int): List<FilmModel> {

        return filmDatabase.shuffled().take(count)
            .mapIndexed { index, film ->
                FilmModel(
                    id = (index + 1).toString(),
                    posterUrl = film.posterUrl,
                    name = film.name,
                    description = film.description,
                    releaseDate = film.releaseDate
                )
            }
    }
}