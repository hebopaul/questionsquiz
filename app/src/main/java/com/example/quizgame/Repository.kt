package com.example.quizgame

import android.util.Log
import com.example.quizgame.api.QuestionsApi
import com.example.quizgame.domain.model.Questions
import com.example.quizgame.domain.model.TriviaCategories
import com.example.quizgame.mapper.toQuestions
import com.example.quizgame.mapper.toTriviaCategories
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: QuestionsApi
) {

    suspend fun getQuestions(categoryId: Int?, difficulty: String?): Questions? {
        try {
            val response = api.getQuestions(category = categoryId, difficulty = difficulty)
            return response.toQuestions()
        } catch (e: Exception){
            Log.d("API Call", "Error: $e")
            return null
        }
    }

    suspend fun getCategories(): TriviaCategories? {
        try {
            val response = api.getCategories()
            return response.toTriviaCategories()
        } catch (e: Exception){
            Log.d("API Call", "Error: $e")
            return null
        }
    }
}