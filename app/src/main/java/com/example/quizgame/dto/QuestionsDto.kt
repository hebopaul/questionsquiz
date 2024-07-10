package com.example.quizgame.dto


import com.google.gson.annotations.SerializedName



data class QuestionsDto(
    @SerializedName("response_code")
    val responseCode: Int,
    @SerializedName("results")
    val questions: List<SingleQuestionDto>
)