package com.example.kakaotalk.presentation.chatlist

import androidx.lifecycle.ViewModel
import com.example.kakaotalk.R
import com.example.kakaotalk.presentation.chatlist.component.model.ChatListItemModel
import com.example.kakaotalk.presentation.chatlist.component.model.FolderItemModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ChatListViewModel : ViewModel() {

    val dummyFolderList = listOf(
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

    val dummyChatList = listOf(
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
        ),
    )
    private val _uiState = MutableStateFlow(
        ChatListUiState(
            chatList = dummyChatList,
            folderList = dummyFolderList
        )
    )
    val uiState: StateFlow<ChatListUiState> = _uiState.asStateFlow()

    fun showModal(id: Int) {
        _uiState.update {
            it.copy(
                selectChatId = id,
                showModal = true
            )
        }
    }

    fun closeModal() {
        _uiState.update {
            it.copy(
                selectChatId = null,
                showModal = false
            )
        }
    }

    fun confirmAction() {
        clearUnread()
        closeModal()
    }

    private fun clearUnread() {
        val targetChatId = uiState.value.selectChatId ?: return

        _uiState.update {
            it.copy(
                chatList = it.chatList.map { chatItem ->
                    if (chatItem.id == targetChatId) {
                        chatItem.copy(unreadCount = 0)
                    } else {
                        chatItem
                    }
                }
            )
        }
    }
}
