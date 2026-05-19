package com.example.kakaotalk.presentation.chatlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme
import com.example.kakaotalk.presentation.chatlist.component.ChatListBottomBar
import com.example.kakaotalk.presentation.chatlist.component.ChatListItem
import com.example.kakaotalk.presentation.chatlist.component.ChatListTopBar
import com.example.kakaotalk.presentation.chatlist.component.menuButton.ChatListMenuButton
import com.example.kakaotalk.presentation.chatlist.component.menuButton.ChatListMenuPlusButton

@Composable
fun ChatListRoute(
    modifier: Modifier = Modifier
) {
    ChatListScreen(
        modifier = modifier,
        onFolderPlusClick = TODO()
    )
}

@Composable
private fun ChatListScreen(
    modifier: Modifier = Modifier,
    onFolderPlusClick: () -> Unit
) {
    var selectedCategoryId by remember { mutableStateOf("item_all") }

    val dummyList = listOf(
        DummyFolder(id = "item_all", text = "전체", number = 0),
        DummyFolder(id = "folder_1", text = "전체 아님ㅋ", number = 11),
        DummyFolder(id = "folder_2", text = "전체 일수도?", number = 212)
    )

    val dummyChatList = listOf(
        ChatListItemModel(
            id = "item_1",
            chatTitle = "Android",
            4,
            date = "어제",
            "아 그저께 두쫀쿠가 진짜 태풍을 일으켰는데 비가 진짜 엄청나게 쏟아지더라 근데 CU 우산이 생각보다 구리다는거",
            unreadCount = 11
        ),
        ChatListItemModel(
            id = "item_2",
            chatTitle = "Sopt 전체",
            5,
            date = "오늘",
            "민경님이랑 친해져야 하는데 교양수업 같이 듣는데 접점이없어요",
            unreadCount = 3
        ),
        ChatListItemModel(
            id = "item_3",
            chatTitle = "하나",
            2,
            date = "05/16",
            "자? 가위 풀 내일 준비물",
            unreadCount = 0
        ),
        ChatListItemModel(
            id = "item_4",
            chatTitle = "둘",
            4,
            date = "05/14",
            "한로로 축제공연 화이팅",
            unreadCount = 3
        ),
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(KakaoTheme.colors.white)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 38.dp, start = 16.dp, end = 16.dp)
                .align(Alignment.TopCenter)
        ) {
            ChatListTopBar()

            Spacer(modifier = Modifier.height(17.dp))

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                items(
                    items = dummyList,
                    key = { it.id }
                ) { item ->
                    ChatListMenuButton(
                        text = item.text,
                        numOfUnread = item.number,
                        isSelected = selectedCategoryId == item.id,
                        onClick = { selectedCategoryId = item.id }
                    )
                }

                item {
                    ChatListMenuPlusButton(
                        onSelected = { onFolderPlusClick() }
                    )
                }
            }

            Spacer(modifier = Modifier.height(22.dp))

            Image(
                painter = painterResource(R.drawable.img_chatlist_banner),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            Spacer(modifier = Modifier.height(15.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                items(
                    items = dummyChatList,
                    key = { it.id }
                ) { item ->
                    ChatListItem(
                        chatTitle = item.chatTitle,
                        memberCount = item.memberCount,
                        date = item.date,
                        chatMessage = item.chatMessage,
                        unreadCount = item.unreadCount
                    )
                }
            }
        }

        ChatListBottomBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .background(KakaoTheme.colors.white)
        )
    }
}

data class DummyFolder(
    val id: String,
    val text: String,
    val number: Int
)

data class ChatListItemModel(
    val id: String,
    val chatTitle: String,
    val memberCount: Int,
    val date: String,
    val chatMessage: String,
    val unreadCount: Int
)

@Preview(showBackground = true)
@Composable
private fun ChatListPreview() {
    KakaoTheme {
        ChatListScreen(
            onFolderPlusClick = TODO()
        )
    }
}
