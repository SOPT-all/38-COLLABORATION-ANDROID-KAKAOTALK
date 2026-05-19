package com.example.kakaotalk.presentation.folder.folderhome.model

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.example.kakaotalk.R
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

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