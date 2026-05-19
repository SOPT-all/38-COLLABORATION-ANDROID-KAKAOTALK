package com.example.kakaotalk.presentation.folder.folderhome.model

import androidx.compose.runtime.Immutable
import com.example.kakaotalk.R

@Immutable
data class FolderHomeAddModel(
    val icon: Int,
    val title: String,
)

val folderHomeList = listOf(
    FolderHomeAddModel(
        icon = R.drawable.ic_gpt_24,
        title = "ChatGPT",
    ),
    FolderHomeAddModel(
        icon = R.drawable.ic_colored_star_24,
        title = "즐겨찾기",
    ),
)