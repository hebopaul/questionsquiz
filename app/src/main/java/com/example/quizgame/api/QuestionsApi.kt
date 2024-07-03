package com.example.quizgame.api

import com.example.quizgame.dto.QuestionsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface QuestionsApi {

    @GET(END_POINT)
    suspend fun getQuestions(
        @Query("amount") numberOfQuestions: Int = 10
    ): QuestionsDto


    companion object {
        const val BASE_URL = "https://opentdb.com/"
        const val END_POINT = "api.php?"
    }
}