package com.example.quizgame

import android.content.Context
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.isUnspecified
import javax.inject.Inject

fun shuffleAnswers(
    rightAnswer: String, wrongAnswers: List<String>
): List<String> {
    if (wrongAnswers.size != 3) throw IllegalArgumentException("Wrong answers must be 3")
    val list = wrongAnswers + rightAnswer
    return list.shuffled()
}

@Composable
fun AutoResizedText(
    text: String,
    style: TextStyle = MaterialTheme.typography.bodySmall,
    modifier: Modifier = Modifier,
    color: Color = style.color
) {
    var resizedTextStyle by remember {
        mutableStateOf(style)
    }

    var shouldDraw by remember {
        mutableStateOf(false)
    }

    val defaultFontSize = MaterialTheme.typography.bodySmall.fontSize

    Text(
        text = text,
        color = color,
        modifier = modifier.drawWithContent {
            if (shouldDraw) {
                drawContent()
            }
        },
        softWrap = true,
        onTextLayout = { result ->
            if (result.didOverflowWidth) {
                if (style.fontSize.isUnspecified) {
                    resizedTextStyle = resizedTextStyle.copy(fontSize = defaultFontSize)
                }
                resizedTextStyle = resizedTextStyle.copy(fontSize = resizedTextStyle.fontSize * 0.9)
            } else {
                shouldDraw = true

            }
        }
    )
}


class Toolset @Inject constructor(
    private val context: Context
) {


    fun getApprovalMessage(
        score: Int, maxScore: Int
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