package com.example.quizgame.dto


import com.google.gson.annotations.SerializedName

data class TriviaCategoriesDto(
    @SerializedName("trivia_categories")
    val list: List<TriviaCategoryDto>
)