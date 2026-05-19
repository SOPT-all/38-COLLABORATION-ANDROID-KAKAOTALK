package com.example.kakaotalk.presentation.folder.foldermore.model

import androidx.compose.runtime.Immutable
import com.example.kakaotalk.R

@Immutable
data class FolderMoreModel(
    val icon: Int,
    val title: String,
)

val folderMoreList = listOf(
    FolderMoreModel(
        icon = R.drawable.ic_gpt_24,
        title = "ChatGPT",
    ),
    FolderMoreModel(
        icon = R.drawable.ic_colored_star_24,
        title = "즐겨찾기",
    ),
    FolderMoreModel(
        icon = R.drawable.ic_edit_bag_24,
        title = "SOPT",
    ),
    FolderMoreModel(
        icon = R.drawable.ic_edit_pencil_24,
        title = "서울여자대학교",
    ),
)