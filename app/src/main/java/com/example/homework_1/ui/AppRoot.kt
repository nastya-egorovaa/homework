package com.example.homework_1.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.homework_1.repository.DataRepository

@Composable
fun AppRoot(
    navHostController: NavHostController,
    repository: DataRepository
) {
    NavHost(
        navController = navHostController,
        startDestination = "first"
    ) {
        composable("first") {
            FirstScreen(
                repository = repository,
                onNavigateToSecond = {
                    navHostController.navigate("second")
                }
            )
        }

        composable("second") {
            SecondScreen(repository = repository)
        }
    }
}