package com.example.homework_1.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.homework_1.model.GameLogic
import com.example.homework_1.model.Results

@Composable
fun GuessNumber () {
    var userInput by remember { mutableStateOf("") }
    var isGuessed by remember { mutableStateOf(false) }
    var gameCounter by remember { mutableStateOf(0) }
    val gameLogic = remember(gameCounter) { GameLogic() }
    var message by remember { mutableStateOf("") }

    BackHandler(enabled = isGuessed) {
        userInput = ""
        message = ""
        isGuessed = false
        gameCounter++
    }

    Column(
        modifier = Modifier
            .padding(50.dp)
            .fillMaxSize()
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        if (isGuessed) {
            AsyncImage(
                model = "https://static.vecteezy.com/system/resources/previews/024/790/278/non_2x/you-win-banner-winner-congratulations-frame-golden-win-congratulating-framed-sign-and-winning-gold-confetti-illustration-vector.jpg",
                contentDescription = "Вы угадали!",
                modifier = Modifier.fillMaxSize()
            )
        } else {

            TextField(
                value = userInput,
                onValueChange = {newInput: String -> userInput = newInput},
                label = { Text("Введите число от 1 до 100") }
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    val guess = userInput.toIntOrNull()
                    if (guess != null) {
                        when (gameLogic.checkNumber(guess))  {
                            Results.Greater -> message = "Задуманное число больше"
                            Results.Lower -> message = "Задуманное число меньше"
                            Results.Correct -> {
                                isGuessed = true
                                message = ""
                            }
                        }
                    }
                }
            ) {
                Text("Проверить")
            }

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = message,
                fontSize = TextUnit(20f, TextUnitType.Sp),
                fontWeight = FontWeight.Bold
            )
        }
    }
}