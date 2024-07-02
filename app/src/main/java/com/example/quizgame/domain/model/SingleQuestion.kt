package com.example.quizgame.domain.model

data class SingleQuestion(
    val askQuestion: String,
    val correctAnswer: String,
    val wrongAnswers: List<String>
)
