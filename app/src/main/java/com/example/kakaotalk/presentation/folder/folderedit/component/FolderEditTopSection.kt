package com.example.kakaotalk.presentation.folder.folderedit.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.designsystem.component.KakaoTopAppBar

@Composable
fun FolderEditTopSection(
    onBackClick: () -> Unit,
    isCompleteEnabled: Boolean,
    selectedIcon: Int,
    folderName: String,
    onFolderNameChange: (String) -> Unit,
    onIconClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        KakaoTopAppBar(
            text = "폴더 편집",
            onBackClick = onBackClick,
            showCompleteAction = true,
            onChangeComplete = isCompleteEnabled
        )

        Spacer(modifier = Modifier.height(40.dp))

        FolderEditIcon(
            icon = if(selectedIcon == R.drawable.ic_no_exist_24) R.drawable.ic_folder_24 else selectedIcon
        )

        Spacer(modifier = Modifier.height(15.dp))

        FolderEditTextField(
            value = folderName,
            onValueChange = onFolderNameChange,
        )

        Spacer(modifier = Modifier.height(49.dp))

        FolderEditIconSection(
            onIconClick = onIconClick,
            selectedIcon = selectedIcon
        )
    }
}