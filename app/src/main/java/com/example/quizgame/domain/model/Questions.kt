package com.example.quizgame.domain.model

data class Questions(
    val list: List<SingleQuestion>?,
) {

    fun getCurrentQuestion(questionId: String): SingleQuestion {
        list?.forEach { question ->
            if (question.questionId == questionId)
                return SingleQuestion(
                    askQuestion = question.askQuestion,
                    correctAnswer = question.correctAnswer,
                    wrongAnswers = question.wrongAnswers,
                    questionNumber = question.questionNumber,
                    questionId = question.questionId
                )
        }
        return SingleQuestion(
            askQuestion = "Something went wrong",
            correctAnswer = "question id did not match data",
            wrongAnswers = listOf("oops", "yikes", "horrendous"),
            questionNumber = 0
        )
    }
}
