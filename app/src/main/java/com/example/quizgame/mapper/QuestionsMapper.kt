package com.example.quizgame.mapper

import com.example.quizgame.domain.model.Questions
import com.example.quizgame.domain.model.SingleQuestion
import com.example.quizgame.domain.model.TriviaCategories
import com.example.quizgame.domain.model.TriviaCategory
import com.example.quizgame.dto.QuestionsDto
import com.example.quizgame.dto.SingleQuestionDto
import com.example.quizgame.dto.TriviaCategoriesDto
import com.example.quizgame.dto.TriviaCategoryDto


fun QuestionsDto.toQuestions() = Questions(
    list = this.questions.mapIndexed { index, it -> it.toSingleQuestion(index+1) }
)


fun SingleQuestionDto.toSingleQuestion(questionNumber: Int) = SingleQuestion(
    askQuestion = this.question,
    correctAnswer = this.correctAnswer,
    wrongAnswers = this.incorrectAnswers,
    questionNumber = questionNumber
)


fun TriviaCategoriesDto.toTriviaCategories() = TriviaCategories(
    list = this.list.map {
        it.toTriviaCategory()
    }
)


fun TriviaCategoryDto.toTriviaCategory() = TriviaCategory(
    id = this.id,
    name = this.name
)

