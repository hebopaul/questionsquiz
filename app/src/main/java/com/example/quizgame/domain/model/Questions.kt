package com.example.quizgame.domain.model

data class Questions (
    val listOfQuestions: List<SingleQuestion>?,
    var correctAnswers: Int = 0,
    val wrongAnswers: Int = 0
)