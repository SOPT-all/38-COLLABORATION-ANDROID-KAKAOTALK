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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kakaotalk.R
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme
import com.example.kakaotalk.presentation.chatlist.component.ChatListBottomBar
import com.example.kakaotalk.presentation.chatlist.component.ChatListItem
import com.example.kakaotalk.presentation.chatlist.component.ChatListTopBar
import com.example.kakaotalk.presentation.chatlist.component.menuButton.ChatListMenuButton
import com.example.kakaotalk.presentation.chatlist.component.menuButton.ChatListMenuPlusButton

@Composable
fun ChatListRoute(
    viewModel: ChatListViewModel = viewModel(),
    modifier: Modifier = Modifier,
    onNavigateToFolderHome: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ChatListScreen(
        uiState = uiState,
        modifier = modifier,
        onFolderPlusClick = { onNavigateToFolderHome() },
        onChatListItemClick = { } // vizewModel.modalVisible등
    )
}

@Composable
private fun ChatListScreen(
    uiState: ChatListUiState,
    modifier: Modifier = Modifier,
    onFolderPlusClick: () -> Unit,
    onChatListItemClick: () -> Unit,
) {
    var selectedCategoryId by remember { mutableStateOf("item_all") }

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
                    items = uiState.folderList,
                    key = { it.id }
                ) { item ->
                    ChatListMenuButton(
                        text = item.name,
                        numOfUnread = item.unreadCount,
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
                    items = uiState.chatList,
                    key = { it.id }
                ) { item ->
                    ChatListItem(
                        chatTitle = item.title,
                        memberCount = item.participantCount,
                        date = item.lastMessageAt,
                        chatMessage = item.lastMessage,
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

@Preview(showBackground = true)
@Composable
private fun ChatListPreview() {
    KakaoTheme {
        ChatListScreen(
            modifier = TODO(),
            onFolderPlusClick = TODO(),
            onChatListItemClick = TODO(),
            uiState = TODO(),
        )
    }
}
