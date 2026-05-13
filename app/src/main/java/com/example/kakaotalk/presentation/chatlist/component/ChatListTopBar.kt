package com.example.kakaotalk.presentation.chatlist.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

@Composable
private fun ChatListTopBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = KakaoTheme.colors.white),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "채팅",
            color = KakaoTheme.colors.black,
            style = KakaoTheme.typography.head1
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_search_24),
                contentDescription = "검색",
            )

            Icon(
                painter = painterResource(R.drawable.ic_chat_plus_24),
                contentDescription = "검색",
            )

            Icon(
                painter = painterResource(R.drawable.ic_setting_24),
                contentDescription = "검색",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ChatListTopBarPreview() {
    KakaoTheme {
        ChatListTopBar()
    }
}
