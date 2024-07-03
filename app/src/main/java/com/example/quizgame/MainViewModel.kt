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
import com.example.quizgame.dto.QuestionsDto
import com.example.quizgame.mapper.toQuestions
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val api: QuestionsApi
): ViewModel() {

    val repository = Repository(api)
    var questions by mutableStateOf<Questions?>(null)
        private set
    var isLoading by mutableStateOf(false)
        private set
    var score by mutableStateOf(0)
        private set
    var questionIndex by mutableStateOf(0)
        private set
    var currentQuestion by mutableStateOf<SingleQuestion?>(null)
        private set

    suspend fun getQuestions() {
        questions = repository.getQuestions()
    }





}