package com.example.kakaotalk.presentation.folder.folderhome

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FolderHomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
    FolderHomeUiState(
            folderName = "기계",
            folderCount = 9,
        )
    )

    val uiState = _uiState.asStateFlow()
}