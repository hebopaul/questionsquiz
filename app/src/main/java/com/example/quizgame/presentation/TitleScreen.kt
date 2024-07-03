package com.example.quizgame.presentation

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizgame.R
import com.example.quizgame.ui.theme.QuizGameTheme


@Composable
fun TitleScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.questions_quiz),
            contentDescription = "logo",
            modifier = Modifier.padding(bottom = 80.dp)
        )

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.size(height = 100.dp, width = 300.dp)
        ) {
            Text(
                text = "New Game",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Preview
@Composable
fun TitleScreenPreview(modifier: Modifier = Modifier) {
    QuizGameTheme {
        TitleScreen()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TitleScreenDarkPreview(modifier: Modifier = Modifier) {
    QuizGameTheme {
        TitleScreen()
    }
}

