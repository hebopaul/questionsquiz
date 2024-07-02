package com.example.quizgame.api

import com.example.quizgame.dto.QuestionsDto
import retrofit2.http.GET

interface QuestionsApi {

    @GET
    suspend fun getQuestions(): QuestionsDto


    companion object {
        const val BASE_URL = "https://opentdb.com/api.php?amount=10"

    }
}