package com.example.homework_1.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.homework_1.repository.DataRepository
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun SecondScreen(repository: DataRepository) {

    var filterText by remember { mutableStateOf("") }
    var displayedList by remember {
        mutableStateOf(repository.getFilms())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = filterText,
            onValueChange = { filterText = it },
            label = { Text("Фильтр по году") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                displayedList = if (filterText.isEmpty()) {
                    repository.getFilms()
                } else {
                    val year = filterText.toIntOrNull()
                    if (year != null) {
                        repository.getFilms().filter { it.releaseDate <= year }
                    } else {
                        repository.getFilms()
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Сортировать")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (displayedList.isEmpty()) {
            Text("Ничего не найдено")
        } else {
            LazyColumn {
                items(count = displayedList.size) { index ->
                    FilmItem(film = displayedList[index])
                }
            }
        }
    }
}