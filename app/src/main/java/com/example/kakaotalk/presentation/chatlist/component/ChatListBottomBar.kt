package com.example.kakaotalk.presentation.chatlist.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.common.extension.noRippleClickable
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

@Composable
fun ChatListBottomBar(
    onChatClick: () -> Unit = {},
    modifier: Modifier = Modifier,
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = 15.dp,
                bottom = 61.dp
            ),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_profile_24),
            contentDescription = null,
            tint = KakaoTheme.colors.gray500
        )

        Icon(
            painter = painterResource(R.drawable.ic_chat_24),
            contentDescription = null,
            tint = KakaoTheme.colors.gray900,
            modifier = Modifier.noRippleClickable(onClick = onChatClick)
        )

        Icon(
            painter = painterResource(R.drawable.ic_shortform_24),
            contentDescription = null,
            tint = KakaoTheme.colors.gray500
        )

        Icon(
            painter = painterResource(R.drawable.ic_shopping_24),
            contentDescription = null,
            tint = KakaoTheme.colors.gray500
        )

        Icon(
            painter = painterResource(R.drawable.ic_more_24),
            contentDescription = null,
            tint = KakaoTheme.colors.gray500
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ChatListBottomBarPreview() {
    KakaoTheme {
        ChatListBottomBar()
    }
}
