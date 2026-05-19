package com.example.kakaotalk.presentation.chatlist.model

import androidx.annotation.DrawableRes

data class FolderItemModel(
    val id: Int,
    val name: String,
    @DrawableRes val icon: Int? = null,
    val unreadCount: Int = 0,
    val isVisible: Boolean = true
)

data class ChatListItemModel(
    val id: Int,
    val title: String,
    val participantCount: Int,
    val lastMessage: String,
    val lastMessageAt: String,
    val unreadCount: Int = 0,
    val folderNames: Array<String> = emptyArray()
)



