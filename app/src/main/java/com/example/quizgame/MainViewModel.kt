package com.example.quizgame

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizgame.api.QuestionsApi
import com.example.quizgame.domain.model.Questions
import com.example.quizgame.domain.model.SingleQuestion
import com.example.quizgame.presentation.MAX_QUESTIONS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val api: QuestionsApi
): ViewModel() {

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
    var isAnswerCorrect by mutableStateOf<Boolean?>(null)


    fun newGame(){
        getQuestions()
        score = 0
        questionNumber = 1
        currentQuestion = questions?.list?.get(0)
        if (currentQuestion == null) { Log.d("MainViewModel", "No questions") }
    }

    fun giveAnswer(answer: String) { isAnswerCorrect(answer) }
    private fun getQuestions() {
        viewModelScope.launch{ questions = repository.getQuestions() }
    }
    fun isAnswerCorrect(answer: String) {
        isAnswerCorrect = currentQuestion?.correctAnswer == answer
        if (isAnswerCorrect == true) {
            score += 10
        }
        nextQuestion()
        isAnswerCorrect = null
    }


    private fun nextQuestion() {
        viewModelScope.launch{
            delay(2000)

            if (questionNumber == questions?.list?.size){
                gameOver()
                return@launch
            }
            questionNumber ++
            currentQuestion = questions?.list?.get(questionNumber - 1)
        }
    }

    private fun gameOver() {
        isGameOver = true

    }

    fun playAgain() {
        newGame()
        isGameOver = false
    }

    fun getEndingMessage(): String {
       return getApprovalMessage(score, MAX_QUESTIONS*10)
    }

}

