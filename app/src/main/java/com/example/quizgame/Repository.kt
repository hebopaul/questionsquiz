package com.example.quizgame

import android.util.Log
import com.example.quizgame.api.QuestionsApi
import com.example.quizgame.domain.model.Questions
import com.example.quizgame.dto.QuestionsDto
import com.example.quizgame.mapper.toQuestions
import kotlinx.coroutines.delay
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: QuestionsApi
) {

    suspend fun getQuestions(): Questions? {
        try {
            val response = api.getQuestions()
            return response.toQuestions()
        } catch (e: Exception){
            Log.d("API Call", "Error: $e")
            return null
        }
    }
}