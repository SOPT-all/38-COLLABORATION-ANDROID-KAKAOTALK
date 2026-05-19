package com.example.kakaotalk.presentation.folder.folderedit

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.designsystem.component.KakaoTopAppBar
import com.example.kakaotalk.presentation.folder.folderedit.component.FolderEditChatList
import com.example.kakaotalk.presentation.folder.folderedit.component.FolderEditIcon
import com.example.kakaotalk.presentation.folder.folderedit.component.FolderEditIconSection
import com.example.kakaotalk.presentation.folder.folderedit.component.FolderEditTextField
import com.example.kakaotalk.presentation.folder.folderedit.component.KakaoFolderSelectItem
import com.example.kakaotalk.presentation.folder.folderedit.model.folderEditChatList

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
    folderName: String,
    onFolderNameChange: (String) -> Unit,
    onIconClick: () -> Unit,
    modifier: Modifier = Modifier,
    isIconSelected: Boolean = false,
    isCompleteEnabled: Boolean = false
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        FolderEditTopSection(
            onBackClick = onBackClick,
            folderName = folderName,
            onFolderNameChange = onFolderNameChange,
            onIconClick = onIconClick,
            isIconSelected = isIconSelected,
            isCompleteEnabled = isCompleteEnabled,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(44.dp))

        HorizontalDivider(
            thickness = 1.dp,
            color = KakaoTheme.colors.gray300
        )

        Spacer(modifier = Modifier.height(25.dp))
    }

}

@Composable
private fun FolderEditTopSection(
    onBackClick: () -> Unit,
    folderName: String,
    onFolderNameChange: (String) -> Unit,
    onIconClick: () -> Unit,
    isIconSelected: Boolean,
    isCompleteEnabled: Boolean,
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

        FolderEditIcon()

        Spacer(modifier = Modifier.height(15.dp))

        FolderEditTextField(
            value = folderName,
            onValueChange = onFolderNameChange,
        )

        Spacer(modifier = Modifier.height(49.dp))

        FolderEditIconSection(
            onIconClick = onIconClick,
            isIconSelected = isIconSelected
        )
    }
}

@Composable
private fun FolderEditBottomSection(
    totalFolder: Int,
    selectedFolder: Int,
    onSelectClick: () -> Unit,
    onClearClick: () -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false
){
    Column(modifier = modifier.height(100.dp)) {
        KakaoFolderSelectItem(
            totalFolder = totalFolder,
            selectedFolder = selectedFolder,
            onSelectClick = onSelectClick,
            onClearClick = onClearClick,
            isSelected = isSelected
        )

        LazyColumn() {
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .border(
                                width = 1.dp,
                                color = KakaoTheme.colors.gray300,
                                shape = RoundedCornerShape(15.dp)
                            )
                            .background(color = KakaoTheme.colors.gray100)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_plus_24),
                            contentDescription = null,
                            modifier = Modifier.align(Alignment.Center),
                            tint = KakaoTheme.colors.gray900
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = "채팅방 추가",
                        color = KakaoTheme.colors.black,
                        style = KakaoTheme.typography.body3
                    )
                }
            }

            items(folderEditChatList)
            { chatlist ->
                FolderEditChatList(
                    chatName = chatlist.chatName,
                    peopleNum = chatlist.peopleNum
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun FolderEditPreview() {
    KakaoTheme {
        var titleText by remember { mutableStateOf("SOPT") }

//        FolderEditScreen(
//            onBackClick = {},
//            titleText = titleText,
//            titleValueChange = { titleText = it },
//            onIconClick = {},
//            isIconSelected = false,
//            onChangeCompleteButton = false
//        )

        FolderEditBottomSection(
            totalFolder = 10,
            selectedFolder = 7,
            onSelectClick = {},
            onClearClick = {},
            isSelected = true
        )
    }
}
