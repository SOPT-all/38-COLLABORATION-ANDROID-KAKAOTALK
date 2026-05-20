package com.example.kakaotalk.presentation.folder.folderedit

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.kakaotalk.presentation.folder.folderedit.model.folderEditChatList
import kotlinx.coroutines.flow.update

class FolderEditViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(FolderEditUiState())
    val uiState: StateFlow<FolderEditUiState> = _uiState.asStateFlow()

    fun updateFolderName(folderName: String) {
        _uiState.update { state ->
            state.copy(folderName = folderName)
        }
    }

    fun updateIcon(icon: Int) {
        _uiState.update { state ->
            state.copy(icon = icon)
        }
    }

    fun toggleSelectAll() {
        _uiState.update { state ->
            val allIds = folderEditChatList.map { it.id }.toSet()
            val updated = if (state.isAllSelected) emptySet() else allIds
            state.copy(selectedChatIds = updated)
        }
    }

    fun toggleChat(id: String) {
        _uiState.update { state ->
            val updated = if (id in state.selectedChatIds) {
                state.selectedChatIds - id
            } else {
                state.selectedChatIds + id
            }
            state.copy(selectedChatIds = updated)
        }
    }
}