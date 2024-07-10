package com.example.quizgame

import android.content.Context
import javax.inject.Inject
    fun shuffleAnswers(
        rightAnswer: String,
        wrongAnswers: List<String>
    ): List<String> {
        if (wrongAnswers.size != 3) throw IllegalArgumentException("Wrong answers must be 3")
        val list = wrongAnswers + rightAnswer
        return list.shuffled()
    }

class Toolset @Inject constructor(
    private val context: Context
) {


    fun getApprovalMessage(
        score: Int,
        maxScore: Int
    ): String {
        val scorePercentage = (score.toDouble() / maxScore)

        return when {
            scorePercentage == 1.0 -> context.getString(R.string.approval_message10)
            scorePercentage >= 0.9 -> context.getString(R.string.approval_message09)
            scorePercentage >= 0.8 -> context.getString(R.string.approval_message08)
            scorePercentage >= 0.7 -> context.getString(R.string.approval_message07)
            scorePercentage >= 0.5 -> context.getString(R.string.approval_message05)
            scorePercentage >= 0.4 -> context.getString(R.string.approval_message04)
            scorePercentage >= 0.3 -> context.getString(R.string.approval_message03)
            scorePercentage >= 0.2 -> context.getString(R.string.approval_message02)
            scorePercentage >= 0.1 -> context.getString(R.string.approval_message01)
            else -> context.getString(R.string.approval_message00)
        }
    }
}