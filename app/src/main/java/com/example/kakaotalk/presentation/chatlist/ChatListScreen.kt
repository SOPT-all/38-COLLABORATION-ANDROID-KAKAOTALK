package com.example.kakaotalk.presentation.chatlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme
import com.example.kakaotalk.presentation.chatlist.component.ChatListBottomBar
import com.example.kakaotalk.presentation.chatlist.component.ChatListTopBar
import com.example.kakaotalk.presentation.chatlist.component.menuButton.ChatListMenuButton
import com.example.kakaotalk.presentation.chatlist.component.menuButton.ChatListMenuPlusButton

@Composable
fun ChatListRoute(
    modifier: Modifier = Modifier
) {
    ChatListScreen(
        modifier = modifier
    )
}

@Composable
private fun ChatListScreen(
    modifier: Modifier = Modifier
) {
    var selectedCategoryId by remember { mutableStateOf("item_all") }

    val dummyList = listOf(
        DummyFolder(id = "item_all", text = "전체", 0),
        DummyFolder(id = "folder_1", text = "전체 아님ㅋ", 11),
        DummyFolder(id = "folder_2", text = "전체 일수도?", 212)
    )

    val dummyChatList = listOf(
        DummyFolder(id = "item_all", text = "전체", 0),
        DummyFolder(id = "folder_1", text = "전체 아님ㅋ", 11),
        DummyFolder(id = "folder_2", text = "전체 일수도?", 212)
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
                        numOfUnread = item.number
                    )
                }

                item {
                    ChatListMenuPlusButton()
                }
            }

            Spacer(modifier = Modifier.height(22.dp))

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
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .background(KakaoTheme.colors.gray200),
                    ) {
                        Text(
                            text = item.text
                        )
                    }
                }
            }
        }
        ChatListBottomBar(
            modifier = Modifier.align(Alignment.BottomCenter).background(KakaoTheme.colors.black)
        )
    }
}

data class DummyFolder(val id: String, val text: String, val number: Int)

@Preview(showBackground = true)
@Composable
private fun ChatListPreview() {
    KakaoTheme {
        ChatListScreen()
    }
}
