package com.example.kakaotalk.core.designsystem.component.KakaFolder

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
fun KakaoFolderNumberItem(
    folderTitle: String,
    folderCount: Int,
    icon: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
){
    Box(
        modifier = modifier
            .width(328.dp)
            .height(30.dp)
            .background(KakaoTheme.colors.white)
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
                    tint = Color.Unspecified
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = folderTitle,
                style = KakaoTheme.typography.body1
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .noRippleClickable(onClick = onClick),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = folderCount.toString(),
                style = KakaoTheme.typography.head3,
                color = KakaoTheme.colors.gray600
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_24),
                contentDescription = null,
                modifier = Modifier.size(18.dp),
                tint = KakaoTheme.colors.gray600
            )
        }
    }
}

@Preview
@Composable
private fun KakaoFolderNumberItemPreview(){
    KakaoTheme {
        Column() {
            KakaoFolderNumberItem(
                folderTitle = "기계",
                folderCount = 9,
                icon = R.drawable.ic_folder_24,
                onClick = {}
            )

            Spacer(modifier = Modifier.height(10.dp))

            KakaoFolderNumberItem(
                folderTitle = "서울여자대학교",
                folderCount = 12,
                icon = R.drawable.ic_edit_pencil_24,
                onClick = {}
            )
        }
    }
}