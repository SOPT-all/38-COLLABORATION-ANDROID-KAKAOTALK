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

sealed class MenuButtonType {
    data object GeneralType : MenuButtonType()
    data class DefaultType(
        @DrawableRes val icon: Int? = null,
        val numOfNoread: Int
    ) : MenuButtonType()
}

@Composable
fun ChatListMenuButton(
    text: String,
    modifier: Modifier = Modifier,
    buttonType: MenuButtonType,
    isSelected: Boolean = false,
    onSelected: () -> Unit = {},
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
                color = if (isSelected) KakaoTheme.colors.black else KakaoTheme.colors.gray300,
                shape = CircleShape
            )
            .noRippleClickable(onClick = onSelected),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            when (buttonType) {
                is MenuButtonType.GeneralType -> {
                    Text(
                        text = text,
                        color = if (isSelected) KakaoTheme.colors.white else KakaoTheme.colors.black,
                        style = KakaoTheme.typography.head2
                    )
                }

                is MenuButtonType.DefaultType -> {
                    buttonType.icon?.let {
                        Icon(
                            painter = painterResource(buttonType.icon),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }

                    Text(
                        text = text,
                        color = if (isSelected) KakaoTheme.colors.white else KakaoTheme.colors.black,
                        style = KakaoTheme.typography.head2
                    )

                    NumOfChat(
                        number = buttonType.numOfNoread
                    )
                }
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
                text = "전체",
                buttonType = MenuButtonType.GeneralType,
            )

            Spacer(modifier = Modifier.width(6.dp))

            ChatListMenuButton(
                text = "안읽음",
                buttonType = MenuButtonType.DefaultType(R.drawable.ic_no_read_24, 11)
            )

            Spacer(modifier = Modifier.width(6.dp))

            ChatListMenuButton(
                text = "히히즐겁당",
                buttonType = MenuButtonType.DefaultType(numOfNoread = 3)
            )

            Spacer(modifier = Modifier.width(6.dp))

            ChatListMenuPlusButton()
        }
    }
}
