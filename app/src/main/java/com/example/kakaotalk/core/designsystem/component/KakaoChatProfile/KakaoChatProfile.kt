package com.example.kakaotalk.core.designsystem.component.KakaoChatProfile

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

//해당 Component는 가독성과 size를 고정하여 컴포넌트 사이즈 문제가 없도록 고려한 컴포넌트입니다
@Composable
fun KakaoChatProfile(
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int = R.drawable.ic_profile_blue_24
) {
    Image(
        painter = painterResource(iconRes),
        contentDescription = null,
        modifier = modifier.size(23.dp)
    )
}

@Preview
@Composable
private fun KakaoChatProfilePreview() {
    KakaoTheme {
        KakaoChatProfile()
    }
}
