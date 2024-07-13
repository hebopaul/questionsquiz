package com.example.quizgame.domain

interface Options {
    val value: Any

}

data class Difficulty(override val value: String) : Options {
    companion object{
        const val EASY = "easy"
        const val MEDIUM = "medium"
        const val HARD = "hard"
    }
}

data class Category(override val value: Int) : Options

