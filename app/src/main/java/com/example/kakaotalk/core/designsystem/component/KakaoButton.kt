package com.example.kakaotalk.core.designsystem.component

import android.R.style.Theme
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

@Composable
fun KakaoButton(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int? = null,
    //디자인시스템 넣어야됨
    textColor: Color = Color.Black,
    backgroundColor: Color = Color.White,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = backgroundColor)
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (iconRes != null) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 4.dp)
                    .size(19.dp),
                //디자인시스템 넣어야됨
                tint = textColor
            )

            Spacer(modifier = Modifier.width(5.dp))
        }

        Text(
            text = text,
            //디자인시스템 넣어야됨
            //color =
            //style =
            color = textColor,
        )
    }
}

@Preview
@Composable
private fun KakaoButtonPreview(){
    KakaoTheme(){
        Column(
        ) {
            KakaoButton(
                text = "작품추가하기",
            )

            KakaoButton(
                text = "작품추가하기",
                iconRes = R.drawable.ic_plus_24,
                textColor = Color.Red,
            )
        }
    }
}