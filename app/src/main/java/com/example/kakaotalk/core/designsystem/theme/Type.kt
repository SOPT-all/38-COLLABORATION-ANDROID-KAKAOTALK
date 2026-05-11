package com.example.kakaotalk.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.designsystem.theme.PretendartFontFamily

@Immutable
data class KakaoTalkTypography(
    val body1: TextStyle,
    val body2: TextStyle,
    val body3: TextStyle,
    val body4: TextStyle,
    val body5: TextStyle,
    val head1: TextStyle,
    val head2: TextStyle,
    val head3: TextStyle,
    val head4: TextStyle
)

private val PretendartFontFamily = FontFamily(
    Font(R.font.pretendard_medium, weight = FontWeight.Normal),
    Font(R.font.pretendard_bold, weight = FontWeight.Bold),
)

val defaultKakaoTalkTypography = KakaoTalkTypography(
    body1 = TextStyle(
        fontFamily = PretendartFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.01.em
    ),
    body2 = TextStyle(
        fontFamily = PretendartFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        letterSpacing = 0.01.em
    ),
    body3 = TextStyle(
        fontFamily = PretendartFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        letterSpacing = 0.01.em
    ),
    body4 = TextStyle(
        fontFamily = PretendartFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.01.em
    ),
    body5 = TextStyle(
        fontFamily = PretendartFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        letterSpacing = 0.01.em
    ),
    head1 = TextStyle(
        fontFamily = PretendartFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        letterSpacing = 0.05.em
    ),
    head2 = TextStyle(
        fontFamily = PretendartFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        letterSpacing = 0.05.em
    ),
    head3 = TextStyle(
        fontFamily = PretendartFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        letterSpacing = 0.05.em
    ),
    head4 = TextStyle(
        fontFamily = PretendartFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        letterSpacing = 0.05.em
    )
)

val LocalKakaoTalkTypographyProvider = staticCompositionLocalOf {
    defaultKakaoTalkTypography
}
