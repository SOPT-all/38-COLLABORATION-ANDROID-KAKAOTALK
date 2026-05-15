package com.example.kakaotalk.presentation.chatlist.component.menuButton

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
fun ChatListMenuButton(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    numOfUnread: Int = 0,
    isSelected: Boolean = false,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .height(40.dp)
            .background(
                color = if (isSelected) KakaoTheme.colors.black else KakaoTheme.colors.white,
                shape = CircleShape
            )
            .border(
                width = 1.dp,
                color = if (isSelected) Color.Unspecified else KakaoTheme.colors.gray300,
                shape = CircleShape
            )
            .noRippleClickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            if (icon != null) {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }

            Text(
                text = text,
                color = if (isSelected) KakaoTheme.colors.white else KakaoTheme.colors.black,
                style = KakaoTheme.typography.head2
            )

            if(numOfUnread > 0) { //혹시 들어올 수도있는 음수의 경우도 고려해서 처리했습니다
                NumOfChat(
                    number = numOfUnread
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ChatListMenuButtonPreview() {
    KakaoTheme {
        Row {
            ChatListMenuButton(
                text = "전체"
            )

            Spacer(modifier = Modifier.width(6.dp))

            ChatListMenuButton(
                text = "안읽음",
                icon = R.drawable.ic_no_read_24,
                numOfUnread = 11
            )

            Spacer(modifier = Modifier.width(6.dp))

            ChatListMenuButton(
                text = "히히즐겁당",
                numOfUnread = 3
            )

            Spacer(modifier = Modifier.width(6.dp))

            ChatListMenuPlusButton()
        }
    }
}
