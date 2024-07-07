package com.example.quizgame

fun shuffleAnswers(
    rightAnswer: String,
    wrongAnswers: List<String>
): List<String> {
    val list = wrongAnswers+rightAnswer
    return list.shuffled()
}


fun getApprovalMessage(score: Int, maxScore: Int): String {
    val scorePercentage = (score.toDouble() / maxScore)
    return when {
        scorePercentage == 1.0 -> "Congratulations! You are a genius wizard!"
        scorePercentage >= 0.9 -> "You are even smarter than super original app!"
        scorePercentage >= 0.8 -> "You docto yet? Talk to me after you docto!"
        scorePercentage >= 0.7 -> "Wow, you be the very smart!"
        scorePercentage >= 0.5 -> "Good job! I've seen better..."
        scorePercentage >= 0.4 -> "Nice! You're almost there!"
        scorePercentage >= 0.3 -> "Okay! You can do better!"
        scorePercentage >= 0.2 -> "You need to work hard!"
        scorePercentage >= 0.1 -> "Congratulations! You have failed successfully!"
        else -> "Congratulations! You are demoted to a monkey's assistant!"

    }
}