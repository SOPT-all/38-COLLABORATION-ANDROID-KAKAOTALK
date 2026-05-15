package com.example.kakaotalk.presentation.chatlist.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.core.designsystem.component.KakaoChatProfile.KakaoChatRoomProfile
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme
import com.example.kakaotalk.presentation.chatlist.component.menuButton.NumOfChat

@Composable
fun ChatListItem(
    chatTitle: String,
    memberCount: Int,
    date: String,
    chatMessage: String,
    unreadCount: Int,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier,
    ) {
        KakaoChatRoomProfile()

        Spacer(modifier = Modifier.width(10.dp))

        Column{
            ChatItemHeader(
                chatTitle = chatTitle,
                memberCount = memberCount,
                date = date,
            )

            Spacer(modifier = Modifier.height(6.dp))

            ChatItemFooter(
                chatMessage = chatMessage,
                unreadCount = unreadCount
            )
        }

    }

}

@Composable
private fun ChatItemHeader(
    chatTitle: String,
    memberCount: Int,
    date: String,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = if (chatTitle.length > 21) chatTitle.take(21) + "…" else chatTitle,
                color = KakaoTheme.colors.black,
                style = KakaoTheme.typography.body1,
            )

            Text(
                text = memberCount.toString(),
                color = KakaoTheme.colors.gray600,
                style = KakaoTheme.typography.body1
            )
        }

        Spacer(modifier= Modifier.width(4.dp))

        Text(
            text = date,
            color = KakaoTheme.colors.gray600,
            style = KakaoTheme.typography.body6
        )
    }
}

@Composable
private fun ChatItemFooter(
    chatMessage: String,
    unreadCount: Int,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = if (chatMessage.length > 46) chatMessage.take(46) + "…" else chatMessage,
            modifier = Modifier.weight(1f),
            color = KakaoTheme.colors.gray700,
            style = KakaoTheme.typography.body3
        )

        if (unreadCount > 0){
            Spacer(modifier= Modifier.width(4.dp))

            NumOfChat(
                number = unreadCount
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ChatListItemPreview() {
    KakaoTheme {
        ChatListItem(
            chatTitle = "채팅리스트",
            memberCount = 123,
            date = "24.11.25",
            chatMessage = "아니이건테스트야 아! 그래 테스트야 나는 지금거실에 있어 안마기하고싶은데 엄마가 안내려옴 ㅠㅠㅠ",
            unreadCount = 123
        )
    }
}
