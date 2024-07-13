package com.example.quizgame.dto


import com.google.gson.annotations.SerializedName

data class TriviaCategoryDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)