package com.example.kakaotalk.core.designsystem.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

@Composable
fun KakaoButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    @DrawableRes iconRes: Int? = null,
    textColor: Color = KakaoTheme.colors.orange300,
    backgroundColor: Color = KakaoTheme.colors.orange100,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = backgroundColor)
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (iconRes != null) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 5.dp)
                    .size(19.dp),
                tint = textColor
            )
        }

        Text(
            text = text,
            color = textColor,
            style = KakaoTheme.typography.body2
        )
    }
}

@Preview
@Composable
private fun KakaoButtonPreview(){
    KakaoTheme{
        Column{
            KakaoButton(
                text = "작품추가하기",
            )

            Spacer(Modifier.height(5.dp))

            KakaoButton(
                text = "작품추가하기",
                iconRes = R.drawable.ic_plus_24,
            )
        }
    }
}
