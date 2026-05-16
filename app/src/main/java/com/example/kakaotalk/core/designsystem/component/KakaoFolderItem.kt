package com.example.kakaotalk.core.designsystem.component

import androidx.annotation.DrawableRes
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
fun KakaoFolderItem(
    text: String,
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier,
    iconColor: Color = Color.Unspecified,
    folderCount: Int = 0,
    onArrowClick: () -> Unit = {},
    isNumVisible: Boolean = false
){
    Row (
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        KakaoFolderIcon(
            icon = icon,
            iconColor = iconColor
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = text,
            style = KakaoTheme.typography.body1
        )

        Spacer(modifier = Modifier.weight(1f))

        if (isNumVisible) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.noRippleClickable(onClick = onArrowClick)
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
        else {
            KakaoRoundedButton(text = "추가")
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun KakaoFolderItemPreview(){
    KakaoTheme{
        Column(){
            KakaoFolderItem(
                text = "ChatGPT",
                icon = R.drawable.ic_gpt_24,
                onArrowClick = {}
            )

            Spacer(modifier = Modifier.height(10.dp))

            KakaoFolderItem(
                text = "즐겨찾기",
                icon = R.drawable.ic_star_24,
                iconColor = KakaoTheme.colors.orange200,
                onArrowClick = {}
            )

            Spacer(modifier = Modifier.height(10.dp))

            KakaoFolderItem(
                text = "기계",
                icon = R.drawable.ic_folder_24,
                folderCount = 9,
                onArrowClick = {},
                isNumVisible = true
            )

            Spacer(modifier = Modifier.height(10.dp))

            KakaoFolderItem(
                text = "서울여자대학교",
                icon = R.drawable.ic_edit_pencil_24,
                folderCount = 12,
                onArrowClick = {},
                isNumVisible = true
            )
        }
    }
}