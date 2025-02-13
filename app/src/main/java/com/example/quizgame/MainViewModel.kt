package com.example.quizgame

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizgame.api.QuestionsApi
import com.example.quizgame.domain.Category
import com.example.quizgame.domain.Difficulty
import com.example.quizgame.domain.Options
import com.example.quizgame.domain.model.Questions
import com.example.quizgame.domain.model.SingleQuestion
import com.example.quizgame.domain.model.TriviaCategory
import com.example.quizgame.presentation.MAX_QUESTIONS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val api: QuestionsApi,
    private val tools: Toolset
) : ViewModel() {

    val repository = Repository(api)
    var questions by mutableStateOf<Questions?>(null)
        private set
    var isGameOver by mutableStateOf(false)
        private set
    var score by mutableStateOf(0)
        private set
    var questionNumber by mutableStateOf(0)
        private set
    var currentQuestion by mutableStateOf<SingleQuestion?>(null)
        private set
    var categories by mutableStateOf<List<TriviaCategory>>(listOf())
    var categoryId by mutableStateOf<Int?>(null)
    var difficulty by mutableStateOf<String?>(null)


    fun newGame() {
        viewModelScope.launch {
            questions = repository.getQuestions(categoryId, difficulty)
            println("questions retrieved")
            score = 0
            questionNumber = 1
            currentQuestion = questions?.list?.get(0)
            println("First question is: ${currentQuestion?.questionId}")
            if (currentQuestion == null) {
                Log.d("MainViewModel", "No questions")
            }
        }
    }

    fun answeredCorrectly() {
        score += 10
        nextQuestion()
    }

    fun answeredIncorrectly() {
        nextQuestion()
    }


    private fun nextQuestion() {
        if (questionNumber == questions?.list?.size) {
            gameOver()
            return
        }
        questionNumber++
        currentQuestion = questions?.list?.get(questionNumber - 1)
    }

    private fun gameOver() {
        isGameOver = true

    }

    fun playAgain() {
        isGameOver = false
        newGame()
    }

    fun getScoreMessage(): String {
        return tools.getApprovalMessage(
            score = when (difficulty) {
                Difficulty.EASY -> score
                Difficulty.MEDIUM -> score * 2
                else -> score * 3
            },
                MAX_QUESTIONS * 10
        )

    }

    fun getCategories() {
        viewModelScope.launch {
            categories = repository.getCategories()?.list ?: listOf<TriviaCategory>()
        }
    }

    fun setOption(option: Options) {
        when (option) {
            is Difficulty -> {
                difficulty = option.value
            }

            is Category -> {
                categoryId = option.value
            }
        }
    }

}

