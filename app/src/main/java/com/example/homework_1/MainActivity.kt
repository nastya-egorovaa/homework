package com.example.homework_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        analyzelnList(listOf(67, -14, 22, -8, 15))

        checkPassword("someTestPassword")
    }
}

fun analyzelnList(input: List<Int>) {

    var evenCount = 0
    var oddCount = 0

    for (number in input) {
        if (number % 2 == 0) {
            evenCount++
        } else {
            oddCount++
        }
    }

    println("Минимальное: ${input.minOrNull()}")
    println("Максимальное: ${input.maxOrNull()}")
    println("Сумма: ${input.sum()}")
    println("Чётных: $evenCount")
    println("Нечётных: $oddCount")
}

fun checkPassword(input: String) {

    var count = 0
    var hasDigit = false
    var hasUpperLetter = false
    var hasLowerLetter = false
    var hasSpecialSymbol = false

    for (item in input) {
        if (item.isDigit()) {
            hasDigit = true
        } else if (item.isUpperCase()) {
            hasUpperLetter = true
        } else if (item.isLowerCase()) {
            hasLowerLetter = true
        } else {
            hasSpecialSymbol = true
        }
    }

    if (input.length >= 8) count++
    if (hasDigit) count++
    if (hasUpperLetter) count++
    if (hasLowerLetter) count++
    if (hasSpecialSymbol) count++

    val strength = when (count) {
        5 -> "надежный"
        4 -> "хороший"
        2, 3 -> "средний"
        else -> "ненадежный"
    }

    println("Надежность пароля: $strength")
}

