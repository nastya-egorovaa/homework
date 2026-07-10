package com.example.homework_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.homework_1.repository.DataRepository
import com.example.homework_1.ui.AppRoot

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val repository = DataRepository()

        setContent {
            MaterialTheme {
                Surface {
                    val navController = rememberNavController()

                    AppRoot(
                        navHostController = navController,
                        repository = repository
                    )
                }
            }
        }
    }
}

