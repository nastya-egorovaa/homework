package com.example.homework_1.model

import kotlin.random.Random

class GameLogic {

    val number: Int = Random.nextInt(0, 101)

    fun checkNumber (userInput: Int): Results {
        return when {
            userInput < number -> Results.Greater
            userInput > number -> Results.Lower
            else -> Results.Correct
        }
    }
}