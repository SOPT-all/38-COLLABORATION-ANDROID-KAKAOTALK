package com.example.kakaotalk.presentation.chatlist

import androidx.lifecycle.ViewModel
import com.example.kakaotalk.R
import com.example.kakaotalk.presentation.chatlist.component.model.ChatListItemModel
import com.example.kakaotalk.presentation.chatlist.component.model.FolderItemModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ChatListViewModel : ViewModel() {

    val dummyFolderList = listOf(
        FolderItemModel(
            id = "item_all", name = "전체", unreadCount = 0,
            icon = TODO()
        ),
        FolderItemModel(
            id = "unread", name = "안읽음", unreadCount = 12,
            icon = R.drawable.ic_no_read_24
        ),
        FolderItemModel(
            id = "folder_1", name = "SOPT", unreadCount = 11,
            icon = TODO()
        ),
        FolderItemModel(
            id = "folder_2", name = "학교", unreadCount = 212,
            icon = TODO()
        )
    )

    val dummyChatList = listOf(
        ChatListItemModel(
            id = "item_1",
            title = "Android",
            participantCount = 4,
            lastMessageAt = "어제",
            lastMessage = "아 그저께 두쫀쿠가 진짜 태풍을 일으켰는데 비가 진짜 엄청나게 쏟아지더라 근데 CU 우산이 생각보다 구리다는거",
            unreadCount = 11,
            folderNames = arrayOf("SOPT")
        ),
        ChatListItemModel(
            id = "item_2",
            title = "Sopt 전체",
            participantCount = 5,
            lastMessageAt = "오늘",
            lastMessage = "민경님이랑 친해져야 하는데 교양수업 같이 듣는데 접점이없어요",
            unreadCount = 3,
            folderNames = arrayOf("SOPT")
        ),
        ChatListItemModel(
            id = "item_3",
            title = "하나",
            participantCount = 2,
            lastMessageAt = "05/16",
            lastMessage = "자? 가위 풀 내일 준비물",
            unreadCount = 0,
            folderNames = arrayOf("학교")
        ),
        ChatListItemModel(
            id = "item_4",
            title = "둘",
            participantCount = 4,
            lastMessageAt = "05/14",
            lastMessage = "한로로 축제공연 화이팅",
            unreadCount = 3
        ),
    )
    private val _uiState = MutableStateFlow(
        ChatListUiState(
            chatList = dummyChatList,
            folderList = dummyFolderList
        )
    )
    val uiState: StateFlow<ChatListUiState> = _uiState.asStateFlow()
}
