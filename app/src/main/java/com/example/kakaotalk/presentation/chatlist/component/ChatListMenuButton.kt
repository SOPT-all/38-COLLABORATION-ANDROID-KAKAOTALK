package com.example.kakaotalk.presentation.chatlist.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.common.extension.noRippleClickable
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

sealed class MenuButtonType() {
    data class DefualtType(val text: String) : MenuButtonType()
    data class NumOfReadType(val number: Int) : MenuButtonType()
    data object PlusMenuType : MenuButtonType()
}

@Composable
fun ChatListMenuButton(
    modifier: Modifier = Modifier,
    type: MenuButtonType,
    selected: Boolean = false,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .height(38.dp)
            .background(
                color = if (selected) KakaoTheme.colors.black else KakaoTheme.colors.white,
                shape = RoundedCornerShape(30.dp)
            )
            .border(
                width = 1.dp,
                color = if (selected) KakaoTheme.colors.black else KakaoTheme.colors.gray300,
                shape = RoundedCornerShape(30.dp) // 둥근 모서리 설정
            )
            .noRippleClickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        when (type) {
            is MenuButtonType.DefualtType -> {
                Text(
                    text = type.text,
                    color = if (selected) KakaoTheme.colors.white else KakaoTheme.colors.black,
                    style = KakaoTheme.typography.head3
                )
            }

            is MenuButtonType.NumOfReadType -> {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_no_read_24),
                        contentDescription = null,
                        modifier = Modifier
                            .size(16.dp)
                            .padding(4.dp),
                    )

                    Text(
                        text = "안읽음",
                        color = if (selected) KakaoTheme.colors.white else KakaoTheme.colors.black,
                        style = KakaoTheme.typography.head3
                    )

                    NumOfChat(
                        number = type.number
                    )

                }
            }

            else -> {}
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ChatListMenuButtonPreview() {
    KakaoTheme {
        Row() {
            ChatListMenuButton(
                type = MenuButtonType.DefualtType("전체"),
            )

            Spacer(modifier = Modifier.width(16.dp))

            ChatListMenuButton(
                type = MenuButtonType.NumOfReadType(16),
            )

            Spacer(modifier = Modifier.width(16.dp))

            ChatListMenuButton(
                type = MenuButtonType.DefualtType("SOPT"),
                selected = true
            )

            Spacer(modifier = Modifier.width(16.dp))

            ChatListMenuButton(
                type = MenuButtonType.PlusMenuType,
                selected = true
            )
        }
    }
}
