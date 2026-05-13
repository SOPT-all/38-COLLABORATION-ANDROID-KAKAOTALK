package com.example.kakaotalk.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

enum class DividerType {
    Default,
    Wide
}

@Composable
fun KakaoDivider(
    dividerType: DividerType,
    modifier: Modifier = Modifier,
    backgroundColor: Color = KakaoTheme.colors.gray200
){
    Box(
        modifier = modifier
            .width(
                if (dividerType == DividerType.Default) 328.dp
                else 360.dp
            )
            .height(1.dp)
            .background(backgroundColor)
    )
}

@Preview
@Composable
private fun KakaoDividerPreview(){
    KakaoTheme{
        Column(){
            KakaoDivider(
                dividerType = DividerType.Default,
                backgroundColor = KakaoTheme.colors.gray100
            )

            Spacer(modifier = Modifier.height(5.dp))

            KakaoDivider(
                dividerType = DividerType.Wide
            )
        }
    }
}