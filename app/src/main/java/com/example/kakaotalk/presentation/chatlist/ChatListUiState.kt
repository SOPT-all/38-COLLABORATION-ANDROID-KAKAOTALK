package com.example.kakaotalk.presentation.chatlist

import com.example.kakaotalk.presentation.chatlist.component.model.ChatListItemModel
import com.example.kakaotalk.presentation.chatlist.component.model.FolderItemModel

data class ChatListUiState (
    val chatList: List<ChatListItemModel>,
    val folderList: List<FolderItemModel>,

    val isLoading: Boolean = false,
    val error: String? = null,
    val isSuccess: Boolean = false,

    )


