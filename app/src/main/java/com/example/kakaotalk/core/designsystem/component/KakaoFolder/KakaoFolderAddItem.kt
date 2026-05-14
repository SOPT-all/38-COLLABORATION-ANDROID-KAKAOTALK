package com.example.kakaotalk.core.designsystem.component.KakaoFolder

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme
@Composable
fun KakaoFolderAddItem(
    text: String,
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier,
    iconColor: Color = KakaoTheme.colors.black,
    backgroundColor: Color = KakaoTheme.colors.white
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor)
    ) {
        Row(
            modifier = Modifier.align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(28.dp)
                    .background(
                        color = KakaoTheme.colors.gray200,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = iconColor
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = text,
                style = KakaoTheme.typography.body1
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .width(45.dp)
                .height(30.dp)
                .border(
                    width = 1.dp,
                    color = KakaoTheme.colors.gray300,
                    shape = RoundedCornerShape(999.dp)
                ),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "추가",
                style = KakaoTheme.typography.body4,
                color = KakaoTheme.colors.black
            )
        }
    }
}


@Preview
@Composable
private fun KakaoFolderAddItemPreview(){
    KakaoTheme{
        Column(){
            KakaoFolderAddItem(
                text = "ChatGPT",
                icon = R.drawable.ic_gpt_24,
            )

            Spacer(modifier = Modifier.height(10.dp))

            KakaoFolderAddItem(
                text = "즐겨찾기",
                icon = R.drawable.ic_star_24,
                iconColor = KakaoTheme.colors.orange200
            )
        }

    }
}