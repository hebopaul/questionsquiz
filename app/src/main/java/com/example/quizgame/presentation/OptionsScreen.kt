package com.example.quizgame.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizgame.AutoResizedText
import com.example.quizgame.R
import com.example.quizgame.domain.Category
import com.example.quizgame.domain.Difficulty
import com.example.quizgame.domain.Options
import com.example.quizgame.domain.model.TriviaCategory
import com.example.quizgame.ui.theme.QuizGameTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OptionsScreen(
    listOfCategories: List<TriviaCategory>,
    onItemClicked: (Options) -> Unit,
    onContinueClicked: () -> Unit,
    chosenCategoryId: Int? = null,
    chosenDifficulty: String? = null
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onContinueClicked() })
        {
            Text(text = "Continue")
        }
        Surface(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .align(Alignment.CenterHorizontally),
            color = MaterialTheme.colorScheme.secondary,
        ) {
            Text(
                text = stringResource(R.string.select_difficulty),
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CardOptionItem(
                text = "Easy",
                modifier = Modifier.width(100.dp),
                onClick = { onItemClicked(Difficulty(Difficulty.EASY)) },
                colors = if (chosenDifficulty == "easy") {
                    CardDefaults.elevatedCardColors(
                        containerColor = Color.Green,
                        contentColor = Color.White
                    )
                } else {
                    CardDefaults.elevatedCardColors()
                }
            )
            CardOptionItem(
                text = "Medium",
                modifier = Modifier.width(100.dp),
                onClick = { onItemClicked(Difficulty(Difficulty.MEDIUM)) },
                colors = if (chosenDifficulty == "medium") {
                    CardDefaults.elevatedCardColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.White
                    )
                } else {
                    CardDefaults.elevatedCardColors()
                }
            )
            CardOptionItem(
                text = "Hard",
                modifier = Modifier.width(100.dp),
                onClick = { onItemClicked(Difficulty(Difficulty.HARD)) },
                colors = if (chosenDifficulty == "medium") {
                    CardDefaults.elevatedCardColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.White
                    )
                } else {
                    CardDefaults.elevatedCardColors()
                }
            )

        }



        Surface(
            modifier = Modifier
                .padding(vertical = 30.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .align(Alignment.CenterHorizontally),
            color = MaterialTheme.colorScheme.secondary,
        ) {
            Text(
                text = stringResource(R.string.select_a_category),
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
        LazyVerticalGrid(columns = GridCells.Fixed(3)) {
            items(listOfCategories.size) { categoryIndex ->
                CardOptionItem(
                    text = listOfCategories[categoryIndex].name,
                    modifier = Modifier.width(100.dp),
                    onClick = { onItemClicked(Category(listOfCategories[categoryIndex].id)) },
                    colors = if (listOfCategories[categoryIndex].id == chosenCategoryId) {
                        CardDefaults.elevatedCardColors(
                            containerColor = Color.Blue,
                            contentColor = Color.White
                        )
                    } else {
                        CardDefaults.elevatedCardColors()
                    }
                )
            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardOptionItem(
    text: String,
    modifier: Modifier,
    onClick: () -> Unit,
    colors: CardColors
) {
    OutlinedCard(

        modifier = modifier
            .height(78.dp)
            .padding(2.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = Color.Gray),
        colors = colors,
        onClick = { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Box(
            modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            AutoResizedText(
                text = text,
                modifier = Modifier
                    .padding(3.dp)
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun OptionsScreenPreview(modifier: Modifier = Modifier) {
    QuizGameTheme {
        OptionsScreen(
            listOfCategories = trivia_categories,
            onItemClicked = {},
            onContinueClicked = {}
        )
    }
}


val trivia_categories = listOf(
    TriviaCategory(
        id = 9,
        name = "General Knowledge"
    ),
    TriviaCategory(
        id = 10,
        name = "Entertainment: Books"
    ),
    TriviaCategory(
        id = 11,
        name = "Entertainment: Film"
    ),
    TriviaCategory(
        id = 12,
        name = "Entertainment: Music"
    ),
    TriviaCategory(
        id = 13,
        name = "Entertainment: Musicals & Theatres"
    ),
    TriviaCategory(
        id = 14,
        name = "Entertainment: Television"
    ),
    TriviaCategory(
        id = 15,
        name = "Entertainment: Video Games"
    ),
    TriviaCategory(
        id = 16,
        name = "Entertainment: Board Games"
    ),
    TriviaCategory(
        id = 17,
        name = "Science & Nature"
    ),
    TriviaCategory(
        id = 18,
        name = "Science: Computers"
    ),
    TriviaCategory(
        id = 19,
        name = "Science: Mathematics"
    ),
    TriviaCategory(
        id = 20,
        name = "Mythology"
    ),
    TriviaCategory(
        id = 21,
        name = "Sports"
    ),
    TriviaCategory(
        id = 22,
        name = "Geography"
    ),
    TriviaCategory(
        id = 23,
        name = "History"
    ),
    TriviaCategory(
        id = 24,
        name = "Politics"
    ),
    TriviaCategory(
        id = 25,
        name = "Art"
    ),
    TriviaCategory(
        id = 26,
        name = "Celebrities"
    ),
    TriviaCategory(
        id = 27,
        name = "Animals"
    ),
    TriviaCategory(
        id = 28,
        name = "Vehicles"
    ),
    TriviaCategory(
        id = 29,
        name = "Entertainment: Comics"
    ),
    TriviaCategory(
        id = 30,
        name = "Science: Gadgets"
    ),
    TriviaCategory(
        id = 31,
        name = "Entertainment: Japanese Anime & Manga"
    ),
    TriviaCategory(
        id = 32,
        name = "Entertainment: Cartoon & Animations"
    )
)