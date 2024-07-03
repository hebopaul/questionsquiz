package com.example.quizgame

fun shuffleAnswers(
    rightAnswer: String,
    wrongAnswers: List<String>
): List<String> {
    val list = wrongAnswers+rightAnswer
    return list.shuffled()
}