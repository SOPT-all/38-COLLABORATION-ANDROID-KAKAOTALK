package com.example.kakaotalk.presentation.folder.folderedit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.core.designsystem.component.KakaoButton
import com.example.kakaotalk.presentation.folder.folderedit.component.FolderEditBottomSection
import com.example.kakaotalk.presentation.folder.folderedit.component.FolderEditTopSection

@Composable
fun FolderEditRoute(
    modifier: Modifier = Modifier
) {
//    FolderEditScreen(
//        onBackClick = {},
//        titleText = "네네",
//        titleValueChange = "네네",
//        modifier = modifier,
//    )
}

@Composable
private fun FolderEditScreen(
    onBackClick: () -> Unit,
    isCompleteEnabled: Boolean,
    folderName: String,
    onFolderNameChange: (String) -> Unit,
    onIconClick: () -> Unit,
    modifier: Modifier = Modifier,
    isIconSelected: Boolean = false,
    totalChatCount: Int,
    selectedChatCount: Int,
    onSelectAllClick: () -> Unit,
    onDeleteSelectedClick: () -> Unit,
    isAllChatSelected: Boolean = false
) {
    Box(modifier = modifier.fillMaxSize()){
        Column(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            FolderEditTopSection(
                onBackClick = onBackClick,
                isCompleteEnabled = isCompleteEnabled,
                folderName = folderName,
                onFolderNameChange = onFolderNameChange,
                onIconClick = onIconClick,
                isIconSelected = isIconSelected,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(44.dp))

            HorizontalDivider(
                thickness = 1.dp,
                color = KakaoTheme.colors.gray300
            )

            Spacer(modifier = Modifier.height(25.dp))

            FolderEditBottomSection(
                totalChatCount = totalChatCount,
                selectedChatCount = selectedChatCount,
                onSelectAllClick = onSelectAllClick,
                onDeleteSelectedClick = onDeleteSelectedClick,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                isAllChatSelected = isAllChatSelected
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
                onClick = {},
                textColor = KakaoTheme.colors.orange300,
                backgroundColor = KakaoTheme.colors.orange100
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FolderEditPreview() {
    KakaoTheme {
        var titleText by remember { mutableStateOf("SOPT") }

        FolderEditScreen(
            onBackClick = {},
            folderName = titleText,
            onFolderNameChange = { titleText = it },
            onIconClick = {},
            isIconSelected = false,
            isCompleteEnabled = false,
            totalChatCount = 10,
            selectedChatCount = 7,
            onSelectAllClick = {},
            onDeleteSelectedClick = {},
            isAllChatSelected = true
        )
    }
}
