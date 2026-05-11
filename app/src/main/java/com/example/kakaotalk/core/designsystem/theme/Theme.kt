import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.kakaotalk.core.designsystem.theme.KakaoTalkColors
import com.example.kakaotalk.core.designsystem.theme.KakaoTalkTypography
import com.example.kakaotalk.core.designsystem.theme.LocalKakaoTalkColorProvider
import com.example.kakaotalk.core.designsystem.theme.LocalKakaoTalkTypographyProvider
import com.example.kakaotalk.core.designsystem.theme.defaultKakaoTalkColors
import com.example.kakaotalk.core.designsystem.theme.defaultKakaoTalkTypography

//해당 Scheme는 Figma System에 기재되어있지 않아 Figma 디자인보고 분석해서 넣어줬습니다.
private val KakaoTalkColorScheme = lightColorScheme(
    // 기본색
    primary = defaultKakaoTalkColors.yellow500,
    onPrimary = defaultKakaoTalkColors.black,

    // 배경색
    background = defaultKakaoTalkColors.white,
    onBackground = defaultKakaoTalkColors.black,

    // 표면색
    surface = defaultKakaoTalkColors.white,
    onSurface = defaultKakaoTalkColors.black,

    // 보조색
    secondary = defaultKakaoTalkColors.blue200,
)


@Composable
fun KakaoTalkTheme(
    colors: KakaoTalkColors = defaultKakaoTalkColors,
    typography: KakaoTalkTypography = defaultKakaoTalkTypography,
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true
        }
    }

    CompositionLocalProvider(
        LocalKakaoTalkColorProvider provides colors,
        LocalKakaoTalkTypographyProvider provides typography
    ) {
        MaterialTheme(
            colorScheme = KakaoTalkColorScheme,
            content = content
        )
    }
}

object KakaoTalkTheme {
    val colors: KakaoTalkColors
        @Composable
        @ReadOnlyComposable
        get() = LocalKakaoTalkColorProvider.current
    val typography: KakaoTalkTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalKakaoTalkTypographyProvider.current
}
