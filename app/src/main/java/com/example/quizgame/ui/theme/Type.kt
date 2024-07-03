package com.example.quizgame.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.quizgame.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val beirutiFontFamily = FontFamily(
    Font(R.font.beiruti_regular, FontWeight.Normal),
    Font(R.font.beiruti_bold, FontWeight.Bold),
    Font(R.font.beiruti_black, FontWeight.Black),
    Font(R.font.beiruti_light, FontWeight.Light),
    Font(R.font.beiruti_medium, FontWeight.Medium),
    Font(R.font.beiruti_semibold, FontWeight.SemiBold),
    Font(R.font.beiruti_extrabold, FontWeight.ExtraBold),
    Font(R.font.beiruti_extralight, FontWeight.ExtraLight),
)