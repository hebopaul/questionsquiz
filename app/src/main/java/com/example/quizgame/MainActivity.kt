package com.example.quizgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.quizgame.presentation.Navigation
import com.example.quizgame.ui.theme.QuizGameTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        setContent {
            QuizGameTheme {
                val viewModel = hiltViewModel<MainViewModel>()
                Navigation(viewModel = viewModel)
            }
        }
    }
}

