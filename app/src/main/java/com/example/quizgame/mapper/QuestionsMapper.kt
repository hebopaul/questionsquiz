package com.example.quizgame.mapper

import com.example.quizgame.domain.model.Questions
import com.example.quizgame.domain.model.SingleQuestion
import com.example.quizgame.dto.QuestionsDto
import com.example.quizgame.dto.SingleQuestionDto



fun QuestionsDto.toQuestions() = Questions(
    listOfQuestions = this.questions.map { it.toSingleQuestion() }
)


fun SingleQuestionDto.toSingleQuestion() = SingleQuestion(
    askQuestion = this.question,
    correctAnswer = this.correctAnswer,
    wrongAnswers = this.incorrectAnswers

)