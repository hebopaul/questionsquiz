package com.example.quizgame.domain.model

import java.util.UUID

data class SingleQuestion(
    val askQuestion: String,
    val correctAnswer: String,
    val wrongAnswers: List<String>,
    val questionNumber: Int,
    val questionId: String = UUID.randomUUID().toString(),
)