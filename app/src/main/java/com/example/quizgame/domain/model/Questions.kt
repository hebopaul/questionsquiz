package com.example.quizgame.domain.model

data class Questions (
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
            askQuestion = "something went wrong",
            correctAnswer = "dis bad",
            wrongAnswers = listOf(
                "oh",
                "no",
                "error"
            ),
            questionNumber = 0
        )
    }
}
