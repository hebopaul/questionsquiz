package com.example.quizgame.presentation

import android.text.Html
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.quizgame.domain.model.Questions
import com.example.quizgame.shuffleAnswers

const val MAX_QUESTIONS = 10

@Composable
fun QuestionScreen(
    questions: Questions,
    questionId: String,
    onAnswerCorrect: () -> Unit,
    onAnswerWrong: () -> Unit
) {
    val question by remember { mutableStateOf(questions.getCurrentQuestion(questionId)) }
    val possibleAnswers by remember {
        derivedStateOf { shuffleAnswers(question.correctAnswer, question.wrongAnswers) }
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(modifier = Modifier.height(200.dp), color = Color.LightGray) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Question ${question.questionNumber}/$MAX_QUESTIONS",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(10.dp)
                )
                Text(
                    text = Html.fromHtml(question.askQuestion).toString(),
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = 40.dp, start = 10.dp)
                )
            }
        }


        Spacer(modifier = Modifier.height(100.dp))

        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            (1..4).forEach { itemNumber ->
                val isCorrect = possibleAnswers[itemNumber - 1] == question.correctAnswer
                var isChosen by remember { mutableStateOf(false) }
                OptionItem(
                    answerNumber = "$itemNumber.",
                    possibleAnswer = possibleAnswers[itemNumber - 1],
                    onClick = {
                        isChosen = true
                        if (isCorrect) onAnswerCorrect()
                        else onAnswerWrong()
                    },
                    colorState = if (isCorrect && isChosen) CardDefaults.outlinedCardColors(
                        containerColor = Color.Green,
                        contentColor = Color.White
                    )
                    else if (!isCorrect && isChosen) CardDefaults.outlinedCardColors(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    )
                    else CardDefaults.elevatedCardColors()
                )
            }
        }


    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OptionItem(
    answerNumber: String,
    possibleAnswer: String,
    onClick: () -> Unit,
    colorState: CardColors,
) {
    OutlinedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
            pressedElevation = 2.dp
        ),
        onClick = {
            onClick()
            Log.d("QUESTION SCREEN", "OptionItem: $possibleAnswer clicked")
        },
        colors = colorState,
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .fillMaxWidth()
    ) {
        Row {
            Text(
                text = answerNumber,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(all = 4.dp)
            )
            Text(
                text = Html.fromHtml(possibleAnswer).toString(),
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(all = 8.dp)
            )
        }
    }
}



