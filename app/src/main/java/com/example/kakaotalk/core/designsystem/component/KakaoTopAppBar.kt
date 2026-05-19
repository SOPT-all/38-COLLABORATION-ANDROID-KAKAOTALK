package com.example.kakaotalk.core.designsystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.common.extension.noRippleClickable
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

@Composable
fun KakaoTopAppBar(
    text: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    showCompleteAction: Boolean = false,
    onChangeComplete: Boolean = false
){
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_line_24),
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp)
                    .noRippleClickable(onClick = onBackClick),
                tint = KakaoTheme.colors.black
            )

            Text(
                text = text,
                modifier = Modifier.padding(start = 16.dp),
                color = KakaoTheme.colors.black,
                style = KakaoTheme.typography.head2
            )
        }

        if (showCompleteAction) {
            Text(
                text = "완료",
                modifier = Modifier
                    .align(Alignment.CenterEnd),
                style = KakaoTheme.typography.body2,
                color = if(onChangeComplete) KakaoTheme.colors.black else KakaoTheme.colors.gray500
            )
        }
    }
}

@Preview
@Composable
private fun KakaoTopAppBarPreview(){
    KakaoTheme {
        Column(){
            KakaoTopAppBar(
                text = "채팅방 폴더 관리",
                onBackClick = {}
            )

            Spacer(modifier = Modifier.size(10.dp))

            KakaoTopAppBar(
                text = "폴더 편집",
                onBackClick = {},
                showCompleteAction = true
            )
        }
    }
}
