package com.example.kakaotalk.core.designsystem.component.KakaoFolder

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.example.kakaotalk.core.common.extension.noRippleClickable
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

@Composable
fun KakaoFolderHeader(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    showMore: Boolean = true,
    backgroundColor: Color = KakaoTheme.colors.white
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = "추천 폴더",
            style = KakaoTheme.typography.head4
        )

        if (showMore) {
            Row(
                modifier = Modifier.noRippleClickable(onClick = onClick),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "더보기",
                    style = KakaoTheme.typography.body5,
                    color = KakaoTheme.colors.gray500
                )

                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_24),
                    modifier = Modifier.size(14.dp),
                    contentDescription = null,
                    tint = KakaoTheme.colors.gray500
                )
            }
        }
    }
}


@Preview
@Composable
private fun KakaoFolderHeaderPreview(){
    KakaoTheme{
        Column(){
            KakaoFolderHeader()

            Spacer(modifier = Modifier.height(10.dp))

            KakaoFolderHeader(
                onClick = {},
                showMore = false
            )
        }

    }
}