package com.example.quizgame.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizgame.MainViewModel
import com.example.quizgame.getApprovalMessage

@Composable
fun Navigation(viewModel: MainViewModel) {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.TitleScreen.route
    ) {
        composable(route = Route.TitleScreen.route) {
            TitleScreen(
                onNewGameClick = {
                    viewModel.newGame()
                    navController.navigate(
                        "question_screen" + "/" + viewModel.currentQuestion?.questionId
                    )
                }
            )
        }

        composable(route = Route.QuestionScreen.route) {
            val questionId = it.arguments?.getString("questionId")
            if (viewModel.questions == null)
            {
                LoadingScreen()
            }
            else {
                QuestionScreen(
                    questions = viewModel.questions!!,
                    questionId = questionId ?: "0"
                )
            }
        }

        composable(route = Route.GameOverScreen.route) {
            val score = it.arguments?.getString("score")?.toInt()
            GameOverScreen(
                score = score ?: 0,
                message = getApprovalMessage(score = score!!, maxScore = MAX_QUESTIONS * 10),
                onHome = { navController.navigate(Route.TitleScreen.route) },
                onPlayAgain = {
                    viewModel.playAgain()
                    navController.navigate(
                        "question_screen" + "/" + viewModel.currentQuestion?.questionId
                    )
                }
            )
        }

    }

}


sealed class Route(val route: String) {
    object TitleScreen : Route("title_screen")
    object QuestionScreen : Route("question_screen/{questionId}")
    object GameOverScreen : Route("game_over_screen{score}")

}