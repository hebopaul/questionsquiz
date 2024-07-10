package com.example.quizgame.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizgame.R
import com.example.quizgame.ui.theme.QuizGameTheme

@Composable
fun GameOverScreen(
    score: Int,
    message: String,
    onPlayAgain: () -> Unit,
    onHome: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.padding(30.dp),
            text = message,
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(200.dp))
        Text(
            modifier = Modifier.padding(30.dp),
            text = stringResource(R.string.your_score_is)+": $score",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(50.dp))
        Box(
            modifier = Modifier
                .height(100.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(color = MaterialTheme.colorScheme.secondary)
                .clickable { onPlayAgain() }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Rounded.Refresh,
                    tint = MaterialTheme.colorScheme.onSecondary,
                    contentDescription = stringResource(R.string.play_again),
                    modifier = Modifier
                        .padding(10.dp)
                        .size(80.dp)
                )
                Text(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    text = stringResource(id = R.string.play_again),
                    style = MaterialTheme.typography.headlineMedium.copy(
                        color = MaterialTheme.colorScheme.onSecondary
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        IconButton(
            onClick = onHome,
            modifier = Modifier
                .size(70.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(MaterialTheme.colorScheme.primary),
            colors = IconButtonDefaults.iconButtonColors()
        ) {
            Icon(
                imageVector = Icons.Rounded.Home,
                contentDescription = "Home",
                tint = MaterialTheme.colorScheme.onPrimary
            )

        }
    }

}


@Preview
@Composable
fun GameOverScreenPreview() {
    QuizGameTheme {
        GameOverScreen(
            score = 10,
            message = "",
            onPlayAgain = {},
            onHome = {}
        )
    }
}
