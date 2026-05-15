package com.example.kakaotalk.core.designsystem.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.core.common.extension.noRippleClickable
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

@Composable
fun KakaoRoundedButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    isClickable: Boolean = true
){
    Box(
        modifier = modifier
            .clip(CircleShape)
            .border(
                width = 1.dp,
                color = KakaoTheme.colors.gray300,
                shape = CircleShape
            )
            .noRippleClickable(
                enabled = isClickable,
                onClick = onClick
            )
            .alpha(if (isClickable) 1f else 0.5f)
            .padding(
                horizontal = 12.dp,
                vertical = 6.dp
            )
    ) {
        Text(
            text = text,
            style = KakaoTheme.typography.body4,
            color = KakaoTheme.colors.black
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun KakaoRoundedButtonPreview(){
    Column(){
        KakaoTheme {
            KakaoRoundedButton(text = "추가")

            Spacer(modifier = Modifier.height(10.dp))

            KakaoRoundedButton(
                text = "선택 삭제",
                isClickable = false
            )

            Spacer(modifier = Modifier.height(10.dp))

            KakaoRoundedButton(text = "선택 삭제")
        }
    }
}