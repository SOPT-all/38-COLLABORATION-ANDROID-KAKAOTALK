package com.example.kakaotalk.core.designsystem.component

import android.R.attr.onClick
import android.R.attr.text
import android.R.attr.textColor
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
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme



@Composable
fun KakaoTopAppBar(
    text: String = "채팅방 폴더 관리",
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    color: Color = KakaoTheme.colors.black,
    isSuccessVisible: Boolean ?= false
){

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_line_24),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 16.dp)
                .size(25.dp),
            tint = color
        )

        Text(
            text = text,
            color = color,
            style = KakaoTheme.typography.head2
        )
        
        if (isSuccessVisible == true) {
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "완료",
                color = color,
                style = KakaoTheme.typography.body2
            )
        }
    }
}

@Preview
@Composable
private fun KakaoTopAppBarPreview(){
    KakaoTheme {
        Column(){
            KakaoTopAppBar()
            Spacer(Modifier.padding(10.dp))
            KakaoTopAppBar(
                text = "폴더 편집",
                isSuccessVisible = true
            )
        }
    }
}
