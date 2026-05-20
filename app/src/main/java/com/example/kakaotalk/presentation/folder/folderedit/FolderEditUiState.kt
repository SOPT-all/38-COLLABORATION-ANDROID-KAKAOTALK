package com.example.kakaotalk.presentation.folder.folderedit

import androidx.compose.runtime.Immutable
import com.example.kakaotalk.R
import com.example.kakaotalk.presentation.folder.folderedit.model.folderEditChatList

@Immutable
data class FolderEditUiState(
    val originalFolderName: String = "Sopt",
    val folderName: String = "Sopt",
    val icon: Int = R.drawable.ic_edit_pencil_24,
    val originalIcon: Int = R.drawable.ic_edit_pencil_24,
    val selectedChatIds: Set<String> = emptySet(),
    val totalChatCount: Int = folderEditChatList.size,
) {
    val selectedChatCount: Int = selectedChatIds.size
    val isAllSelected: Boolean = selectedChatIds.size == totalChatCount
    val isCompleteEnabled: Boolean = folderName != originalFolderName || icon != originalIcon
}