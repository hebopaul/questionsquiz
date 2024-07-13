package com.example.quizgame.api

import com.example.quizgame.dto.QuestionsDto
import com.example.quizgame.dto.TriviaCategoriesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface QuestionsApi {

    @GET(QUESTIONS_END_POINT)
    suspend fun getQuestions(
        @Query("amount") numberOfQuestions: Int = 10,
        @Query("type") type: String = "multiple",
        @Query("category") category: Int? = null,
        @Query("difficulty") difficulty: String? = null
    ): QuestionsDto

    @GET(CATEGORIES_END_POINT)
    suspend fun getCategories(): TriviaCategoriesDto




    companion object {
        const val BASE_URL = "https://opentdb.com/"
        const val QUESTIONS_END_POINT = "api.php?"
        const val CATEGORIES_END_POINT = "api_category.php"
    }
}