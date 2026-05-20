package com.example.kakaotalk.presentation.chatlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import com.example.kakaotalk.core.designsystem.component.KakaoModal
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme
import com.example.kakaotalk.presentation.chatlist.component.ChatListBottomBar
import com.example.kakaotalk.presentation.chatlist.component.ChatListItem
import com.example.kakaotalk.presentation.chatlist.component.ChatListTopBar
import com.example.kakaotalk.presentation.chatlist.component.menuButton.ChatListMenuButton
import com.example.kakaotalk.presentation.chatlist.component.menuButton.ChatListMenuPlusButton
import com.example.kakaotalk.presentation.chatlist.model.ChatListItemModel
import com.example.kakaotalk.presentation.chatlist.model.FolderItemModel

@Composable
fun ChatListRoute(
    paddingValues: PaddingValues,
    NavigateToFolderHome: () -> Unit,
    viewModel: ChatListViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ChatListScreen(
        uiState = uiState,
        modifier = Modifier.padding(paddingValues),
        onFolderPlusClick = NavigateToFolderHome,
        onChatListItemClick = { id -> viewModel.showModal(id) },
        onConfirmClick = viewModel::confirmAction,
        onDismissClick = viewModel::closeModal, // viewModel.modalVisible등
    )
}

@Composable
private fun ChatListScreen(
    uiState: ChatListUiState,
    modifier: Modifier = Modifier,
    onFolderPlusClick: () -> Unit,
    onChatListItemClick: (id: Int) -> Unit,
    onConfirmClick: () -> Unit,
    onDismissClick: () -> Unit
) {
    var selectedCategoryId by remember { mutableStateOf(-1) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(KakaoTheme.colors.white)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 38.dp)
                .padding(horizontal = 16.dp)
                .align(Alignment.TopCenter)
        ) {
            ChatListTopBar()

            Spacer(modifier = Modifier.height(17.dp))

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                val visibleFolders = uiState.folderList.filter { it.isVisible == true }

                items(
                    items = visibleFolders,
                    key = { it.id }
                ) { item ->
                    ChatListMenuButton(
                        text = item.name,
                        icon = item.icon,
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
                    .weight(1f)
                    .padding(bottom = 100.dp),
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
                        unreadCount = item.unreadCount,
                        onClick = { onChatListItemClick(item.id) }
                    )
                }
            }
        }

        ChatListBottomBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .background(KakaoTheme.colors.white)
        )

        if (uiState.showModal) {
            KakaoModal(
                title = "안읽은 메시지 확인",
                description = "해당 채팅방에 안읽은 메시지를 모두 읽음 처리 했습니다.",
                cancelText = "취소",
                confirmText = "확인",
                onConfirm = { onConfirmClick() },
                onDismiss = { onDismissClick() }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ChatListPreview() {
    KakaoTheme {
        ChatListScreen(
            modifier = Modifier,
            onFolderPlusClick = { },
            onChatListItemClick = { },
            uiState = ChatListUiState(
                chatList = listOf(
                    ChatListItemModel(
                        id = 1,
                        title = "Android",
                        participantCount = 4,
                        lastMessageAt = "어제",
                        lastMessage = "아 그저께 두쫀쿠가 진짜 태풍을 일으켰는데 비가 진짜 엄청나게 쏟아지더라 근데 CU 우산이 생각보다 구리다는거",
                        unreadCount = 11,
                        folderNames = arrayOf("SOPT")
                    ),
                    ChatListItemModel(
                        id = 2,
                        title = "Sopt 전체",
                        participantCount = 5,
                        lastMessageAt = "오늘",
                        lastMessage = "민경님이랑 친해져야 하는데 교양수업 같이 듣는데 접점이없어요",
                        unreadCount = 3,
                        folderNames = arrayOf("SOPT")
                    ),
                    ChatListItemModel(
                        id = 3,
                        title = "하나",
                        participantCount = 2,
                        lastMessageAt = "05/16",
                        lastMessage = "자? 가위 풀 내일 준비물",
                        unreadCount = 0,
                        folderNames = arrayOf("학교")
                    ),
                    ChatListItemModel(
                        id = 4,
                        title = "둘",
                        participantCount = 4,
                        lastMessageAt = "05/14",
                        lastMessage = "한로로 축제공연 화이팅",
                        unreadCount = 3
                    )
                ),
                folderList = listOf(
                    FolderItemModel(
                        id = -1, name = "전체", unreadCount = 0
                    ),
                    FolderItemModel(
                        id = -2, name = "안읽음", unreadCount = 12,
                        icon = R.drawable.ic_no_read_24
                    ),
                    FolderItemModel(
                        id = 1, name = "SOPT", unreadCount = 11
                    ),
                    FolderItemModel(
                        id = 2, name = "학교", unreadCount = 212
                    )
                )
            ),
            onConfirmClick = { },
            onDismissClick = { }
        )
    }
}
