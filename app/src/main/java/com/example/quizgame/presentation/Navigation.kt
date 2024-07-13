package com.example.quizgame.presentation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizgame.MainViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun Navigation(viewModel: MainViewModel) {

    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    viewModel.getCategories()

    NavHost(
        navController = navController,
        startDestination = Route.TitleScreen.route
    ) {
        composable(route = Route.TitleScreen.route) {
            TitleScreen(
                onNewGameClick = {
                    navController.navigate(Route.OptionsScreen.route)
                }
            )
        }

        composable(route = Route.QuestionScreen.route) {
            val questionId = it.arguments?.getString("questionId")
            Log.d("Navigation", "questionId: $questionId")

            LaunchedEffect(key1 = viewModel.isGameOver) {
                if (viewModel.isGameOver) {
                    navController.navigate(
                        "game_over_screen/" + viewModel.score
                    )
                }
            }

            if (viewModel.questions == null) {
                LoadingScreen()
            } else
                QuestionScreen(
                    questions = viewModel.questions!!,
                    questionId = questionId ?: "0",
                    onAnswerWrong = {
                        viewModel.answeredIncorrectly()
                        Log.d("Navigation", "onAnswerWrong")
                        scope.launch {
                            delay(1500)
                            navController.navigate(
                                "question_screen/" + viewModel.currentQuestion?.questionId
                            )
                        }
                    },
                    onAnswerCorrect = {
                        viewModel.answeredCorrectly()
                        Log.d("Navigation", "onAnswerCorrect")
                        scope.launch {
                            delay(1500)
                            navController.navigate(
                                "question_screen/" + viewModel.currentQuestion?.questionId
                            )
                        }
                    },
                )

        }

        composable(route = Route.GameOverScreen.route) {
            val score = it.arguments?.getString("score")?.toInt()
            Log.d("Navigation", "score: $score")
            GameOverScreen(
                score = score ?: 0,
                message = viewModel.getScoreMessage(),
                onHome = { navController.navigate(Route.TitleScreen.route) },
                onPlayAgain = {
                    scope.launch {
                        viewModel.playAgain()
                        delay(500)
                        navController.navigate(
                            "question_screen/" + viewModel.currentQuestion?.questionId
                        )
                    }
                }
            )
        }

        composable(route = Route.OptionsScreen.route) {
            OptionsScreen(
                listOfCategories = viewModel.categories,
                onItemClicked = { viewModel.setOption(it) },
                onContinueClicked = {
                    scope.launch{
                        viewModel.newGame()
                        delay(2000)
                        navController.navigate(
                            "question_screen/" + viewModel.currentQuestion?.questionId
                        )
                    }
                }
            )

        }
    }
}


sealed class Route(val route: String) {
    object TitleScreen : Route("title_screen")
    object QuestionScreen : Route("question_screen/{questionId}")
    object GameOverScreen : Route("game_over_screen/{score}")
    object OptionsScreen : Route("options_screen")
}

