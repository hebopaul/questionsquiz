package com.example.quizgame.mapper

import com.example.quizgame.domain.model.Questions
import com.example.quizgame.domain.model.SingleQuestion
import com.example.quizgame.dto.QuestionsDto
import com.example.quizgame.dto.SingleQuestionDto



fun QuestionsDto.toQuestions() = Questions(
    list = this.questions.mapIndexed { index, it -> it.toSingleQuestion(index+1) }
)


fun SingleQuestionDto.toSingleQuestion(questionNumber: Int) = SingleQuestion(
    askQuestion = this.question,
    correctAnswer = this.correctAnswer,
    wrongAnswers = this.incorrectAnswers,
    questionNumber = questionNumber
)