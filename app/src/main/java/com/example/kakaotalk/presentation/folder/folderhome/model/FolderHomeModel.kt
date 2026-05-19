package com.example.kakaotalk.presentation.folder.folderhome.model

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.example.kakaotalk.R

@Immutable
data class FolderHomeAddModel(
    val icon: Int,
    val title: String,
    val iconColor: Color
)

val folderHomeList = listOf(
    FolderHomeAddModel(
        icon = R.drawable.ic_gpt_24,
        title = "ChatGPT",
        iconColor = Color.Unspecified,
    ),
    FolderHomeAddModel(
        icon = R.drawable.ic_star_24,
        title = "즐겨찾기",
        iconColor = Color.Unspecified,
//        iconColor = KakaoTheme.colors.orange200,
    ),
)

@Immutable
data class FolderHomeNumberModel(
    val icon: Int,
    val title: String,
    val folderCount: Int,
)

val folderHomeNumberList = listOf(
    FolderHomeNumberModel(
        icon = R.drawable.ic_edit_pencil_24,
        title = "SOPT",
        folderCount = 9,
    ),
    FolderHomeNumberModel(
        icon = R.drawable.ic_edit_bag_24,
        title = "학교",
        folderCount = 3,
    ),
    FolderHomeNumberModel(
        icon = R.drawable.ic_folder_24,
        title = "기계",
        folderCount = 7,
    ),
    FolderHomeNumberModel(
        icon = R.drawable.ic_edit_heart_24,
        title = "졸업",
        folderCount = 1,
    ),
)