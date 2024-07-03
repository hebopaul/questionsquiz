package com.example.quizgame.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizgame.ui.theme.QuizGameTheme

const val MAX_QUESTIONS = 10

@Composable
fun QuestionScreen(
    modifier: Modifier = Modifier,
    questionNumber: Int,
    question: String,
    possibleAnswers: List<String>
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(modifier = Modifier.height(200.dp), color = Color.LightGray){
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "Question $questionNumber/$MAX_QUESTIONS",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(10.dp)
                )
                Text(
                    text = question,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = 40.dp)
                )
            }
        }


        Spacer(modifier = Modifier.height(100.dp))

        Column(
            modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            (1..4).forEach { itemNumber ->
                OptionItem(
                    itemNumber = itemNumber.toString()+".",
                    optionString = possibleAnswers[itemNumber - 1]
                )
            }
        }


    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OptionItem(
    modifier: Modifier = Modifier,
    itemNumber: String,
    optionString: String
) {
    OutlinedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
            pressedElevation = 2.dp
        ),
        onClick = {},
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .fillMaxWidth()
    ) {
        Row {
            Text(
                text = itemNumber,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(all = 4.dp)
            )
            Text(
                text = optionString,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(all = 8.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun QuestionScreenPreview(modifier: Modifier = Modifier) {
    QuizGameTheme {
        QuestionScreen(
            questionNumber = 1,
            question = "What color is the warmest color?",
            possibleAnswers = listOf(
                "Red",
                "Blue",
                "Yellow",
                "I'm colorblind, how dare you! 23423$#@#"
            )
        )
    }
}