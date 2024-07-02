package com.example.quizgame

import com.example.quizgame.api.QuestionsApi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val api: QuestionsApi
){


}