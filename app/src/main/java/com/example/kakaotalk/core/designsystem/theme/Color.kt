package com.example.kakaotalk.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class KakaoTalkColors(
    val gray900: Color,
    val gray800: Color,
    val gray700: Color,
    val gray600: Color,
    val gray500: Color,
    val gray400: Color,
    val gray300: Color,
    val gray200: Color,
    val gray100: Color,

    val blue300: Color,
    val blue200: Color,
    val blue100: Color,

    val white: Color,
    val black: Color,

    val yellow400: Color,
    val yellow500: Color,
    val yellow600: Color,

    val orange300: Color,
    val orange200: Color,
    val orange100: Color
)

val defaultKakaoTalkColors = KakaoTalkColors(
    gray900 = Color(0xFF393939),
    gray800 = Color(0xFF4D4D4D),
    gray700 = Color(0xFF595959),
    gray600 = Color(0xFF737373),
    gray500 = Color(0xFFB6B6B6),
    gray400 = Color(0xFFCDCDCD),
    gray300 = Color(0xFFDBDBDB),
    gray200 = Color(0xFFF0F0F0),
    gray100 = Color(0xFFF5F5F5),

    blue300 = Color(0xFF2F363E),
    blue200 = Color(0xFF4A535A),
    blue100 = Color(0xFFB8BCBF),

    white = Color(0xFFFFFFFF),
    black = Color(0xFF191919),

    yellow400 = Color(0xFFFFF9C4),
    yellow500 = Color(0xFFFEE500),
    yellow600 = Color(0xFFF6DE00),

    orange300 = Color(0xFFEA5B21),
    orange200 = Color(0xFFFF9117),
    orange100 = Color(0xFFFDEEE7)
)

val LocalKakaoTalkColorProvider = staticCompositionLocalOf {
    defaultKakaoTalkColors
}
