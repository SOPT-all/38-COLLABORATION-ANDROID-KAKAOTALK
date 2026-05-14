package com.example.kakaotalk.presentation.chatlist.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.example.kakaotalk.core.common.extension.noRippleClickable
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

sealed class MenuButtonType {
    data class DefaultType(val text: String) : MenuButtonType()
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
    // sealed 처리해서 한번에 공컴으로 처리하고 싶어서 color도 함수 변수로 처리했습니다
    // PlusMenuType일땐 selected 상관없이 onClick만 감지하면 되서 색깔바뀌지 않게 고려한 코드입니다.
    val backgroundColor = when {
        type is MenuButtonType.PlusMenuType -> KakaoTheme.colors.white
        selected -> KakaoTheme.colors.black
        else -> KakaoTheme.colors.white
    }
    val borderColor = when {
        type is MenuButtonType.PlusMenuType -> KakaoTheme.colors.gray300
        selected -> KakaoTheme.colors.black
        else -> KakaoTheme.colors.gray300
    }


    Box(
        modifier = modifier
            .height(38.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(30.dp)
            )
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(30.dp)
            )
            .noRippleClickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        when (type) {
            is MenuButtonType.DefaultType -> {
                Text(
                    text = type.text,
                    modifier = Modifier.padding(horizontal = 17.dp),
                    color = if (selected) KakaoTheme.colors.white else KakaoTheme.colors.black,
                    style = KakaoTheme.typography.head3
                )
            }

            is MenuButtonType.NumOfReadType -> {
                Row(
                    modifier = Modifier.padding(horizontal = 13.dp),
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_no_read_24),
                        contentDescription = null,
                        tint = Color.Unspecified
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

            is MenuButtonType.PlusMenuType -> {
                Icon(
                    painter = painterResource(R.drawable.ic_foler_plus_24),
                    contentDescription = null,
                    tint = null,
                    modifier = Modifier.padding(horizontal = 7.dp)
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
                type = MenuButtonType.DefaultType("전체"),
            )

            Spacer(modifier = Modifier.width(16.dp))

            ChatListMenuButton(
                type = MenuButtonType.NumOfReadType(16),
            )

            Spacer(modifier = Modifier.width(16.dp))

            ChatListMenuButton(
                type = MenuButtonType.DefaultType("SOPT"),
                selected = true
            )

            Spacer(modifier = Modifier.width(16.dp))

            ChatListMenuButton(
                type = MenuButtonType.PlusMenuType,
            )
        }
    }
}
