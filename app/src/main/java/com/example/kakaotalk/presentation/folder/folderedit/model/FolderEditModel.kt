package com.example.kakaotalk.presentation.folder.folderedit.model

import androidx.compose.runtime.Immutable
import com.example.kakaotalk.R
import java.util.UUID

val iconList = listOf(
    R.drawable.ic_no_exist_24,
    R.drawable.ic_edit_house_24,
    R.drawable.ic_edit_bag_24,
    R.drawable.ic_edit_heart_24,
    R.drawable.ic_edit_pencil_24,
    R.drawable.ic_edit_redbag_24,
    R.drawable.ic_edit_card_24,
    R.drawable.ic_edit_airplane_24,
    R.drawable.ic_edit_plus_24,
    R.drawable.ic_edit_chunsik_24,
    R.drawable.ic_edit_lion_24,
    R.drawable.ic_edit_jordi_24,
    R.drawable.ic_edit_cat_24,
    R.drawable.ic_edit_dog_24,
)

@Immutable
data class FolderEditChatListModel(
    val chatName: String,
    val peopleNum: Int,
)

val folderEditChatList = listOf(
    FolderEditChatListModel(
        chatName = "[Let’s SOPT] 벋벋 17조",
        peopleNum = 7
    ),
    FolderEditChatListModel(
        chatName = "35기 SSARA 대화방",
        peopleNum = 76
    ),
    FolderEditChatListModel(
        chatName = "기계공학부 23번 공지방",
        peopleNum = 76
    ),
)