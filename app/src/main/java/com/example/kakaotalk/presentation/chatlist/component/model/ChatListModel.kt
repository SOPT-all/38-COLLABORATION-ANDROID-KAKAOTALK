package com.example.kakaotalk.presentation.chatlist.component.model

import androidx.annotation.DrawableRes

data class FolderItemModel(
    val id: String,
    val name: String,
    @DrawableRes val icon: Int,
    val unreadCount: Int
)

data class ChatListItemModel(
    val id: String,
    val title: String,
    val participantCount: Int,
    val lastMessage: String,
    val lastMessageAt: String,
    val unreadCount: Int,
    val folderNames: Array<String> = emptyArray()
)



