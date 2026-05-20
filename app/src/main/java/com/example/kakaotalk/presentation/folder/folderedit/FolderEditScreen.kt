package com.example.kakaotalk.presentation.folder.folderedit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kakaotalk.core.designsystem.component.KakaoButton
import com.example.kakaotalk.core.designsystem.component.KakaoModal
import com.example.kakaotalk.presentation.folder.folderedit.component.FolderEditBottomSection
import com.example.kakaotalk.presentation.folder.folderedit.component.FolderEditTopSection
import kotlinx.serialization.Serializable

@Serializable
data object FolderEdit

@Composable
fun FolderEditRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    viewModel: FolderEditViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    FolderEditScreen(
        uiState = uiState,
        onBackClick = navigateUp,
        onFolderNameChange = viewModel::updateFolderName,
        onIconClick = viewModel::updateIcon,
        onChatClick = viewModel::toggleChat,
        onSelectAllClick = viewModel::toggleSelectAll,
        modifier = Modifier.padding(paddingValues),
    )
}

@Composable
private fun FolderEditScreen(
    uiState: FolderEditUiState,
    onBackClick: () -> Unit,
    onFolderNameChange: (String) -> Unit,
    onIconClick: (Int) -> Unit,
    onChatClick: (String) -> Unit,
    onSelectAllClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var isDeleteFolderModalVisible by remember { mutableStateOf(false) }
    var isDeleteSelectedChatModalVisible by remember { mutableStateOf(false) }
    var isDeleteAllChatModalVisible by remember { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxSize()){
        Column(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            FolderEditTopSection(
                onBackClick = onBackClick,
                isCompleteEnabled = uiState.isCompleteEnabled,
                selectedIcon = uiState.icon,
                folderName = uiState.folderName,
                onFolderNameChange = onFolderNameChange,
                onIconClick = onIconClick,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(44.dp))

            HorizontalDivider(
                thickness = 1.dp,
                color = KakaoTheme.colors.gray300
            )

            Spacer(modifier = Modifier.height(25.dp))

            FolderEditBottomSection(
                totalChatCount = uiState.totalChatCount,
                selectedChatCount = uiState.selectedChatCount,
                selectedChatIds = uiState.selectedChatIds,
                onSelectAllClick = onSelectAllClick,
                onDeleteSelectedClick = {
                    if (uiState.totalChatCount == uiState.selectedChatCount)
                        isDeleteAllChatModalVisible = true
                    else isDeleteSelectedChatModalVisible = true
                                        },
                onChatClick = onChatClick,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                isAllChatSelected = uiState.isAllSelected
            )

            Spacer(modifier = Modifier.height(100.dp))
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(100.dp)
                .background(KakaoTheme.colors.white),
            contentAlignment = Alignment.Center
        ) {
            KakaoButton(
                text = "폴더 삭제하기",
                modifier = Modifier.padding(horizontal = 16.dp),
                onClick = { isDeleteFolderModalVisible = true },
                textColor = KakaoTheme.colors.orange300,
                backgroundColor = KakaoTheme.colors.orange100
            )
        }
    }
    if (isDeleteFolderModalVisible) {
        KakaoModal(
            title = "채팅방 폴더 삭제",
            description = "폴더를 삭제하시겠습니까? 폴더가 삭제되어도 채팅방은 나가기 되지 않습니다.",
            cancelText = "취소",
            confirmText = "삭제",
            onDismiss = {isDeleteFolderModalVisible=false},
            onConfirm = {},
        )
    }

    if (isDeleteSelectedChatModalVisible) {
        KakaoModal(
            title = "채팅방 선택 삭제",
            description = "선택하신 채팅방을 삭제하시겠습니까? 폴더에서 삭제되어도 채팅방은 나가기 되지 않습니다.",
            cancelText = "취소",
            confirmText = "삭제",
            onDismiss = {isDeleteSelectedChatModalVisible=false},
            onConfirm = {},
        )
    }

    if (isDeleteAllChatModalVisible) {
        KakaoModal(
            title = "채팅방 전체 삭제",
            description = "채팅방이 전체 선택 되었습니다. 삭제하실 경우 폴더가 삭제됩니다. 폴더가 삭제되어도 채팅방은 나가기 되지 않습니다.",
            cancelText = "취소",
            confirmText = "삭제",
            onDismiss = {isDeleteAllChatModalVisible=false},
            onConfirm = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FolderEditPreview() {
    KakaoTheme {

//        FolderEditScreen(
//            onBackClick = {},
//            onFolderNameChange = { },
//            onIconClick = {},
//            isIconSelected = false,
//            isCompleteEnabled = false,
//            totalChatCount = 10,
//            selectedChatCount = 7,
//            onSelectAllClick = {},
//            onDeleteSelectedClick = {},
//            isAllChatSelected = false
//        )
    }
}