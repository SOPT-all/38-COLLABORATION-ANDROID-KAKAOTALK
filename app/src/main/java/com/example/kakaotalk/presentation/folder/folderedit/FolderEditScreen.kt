package com.example.kakaotalk.presentation.folder.folderedit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.designsystem.component.KakaoFolderItem
import com.example.kakaotalk.core.designsystem.component.KakaoTopAppBar
import com.example.kakaotalk.presentation.folder.folderhome.DummyFolder
import com.example.kakaotalk.presentation.folder.folderhome.component.KakaoFolderHeader

@Composable
fun FolderEditRoute(
    modifier: Modifier = Modifier
) {
    FolderEditScreen(
        modifier = modifier
    )
}

@Composable
private fun FolderEditScreen(
    modifier: Modifier = Modifier
        .background(KakaoTheme.colors.white)
        .fillMaxSize()
) {
    val dummyFolderList = listOf(
        DummyFolder(
            title = "기계",
            icon = R.drawable.ic_folder_24,
            iconColor = Color.Unspecified,
            folderCount = 9,
            onArrowClick = {}
        ),
        DummyFolder(
            title = "서울여자대학교",
            icon = R.drawable.ic_edit_pencil_24,
            iconColor = Color.Unspecified,
            folderCount = 11,
            onArrowClick = {}
        ),
        DummyFolder(
            title = "SOPT",
            icon = R.drawable.ic_edit_bag_24,
            iconColor = Color.Unspecified,
            folderCount = 3,
            onArrowClick = {}
        )
    )

    Column(
        modifier = modifier.padding(
            start = 16.dp,
            end = 16.dp
        ),
        verticalArrangement = Arrangement.spacedBy(26.dp)
    ) {
        KakaoTopAppBar(
            modifier = Modifier.padding(top = 41.dp),
            text = "채팅방 폴더 관리",
            onBackClick = {}
        )

        KakaoFolderHeader(
            modifier = Modifier.padding(top = 24.dp),
            isMoreVisible = false
        )

        dummyFolderList.forEachIndexed { index, folder ->
            KakaoFolderItem(
                text = folder.title,
                icon = folder.icon,
                iconColor = folder.iconColor,
                onArrowClick = folder.onArrowClick
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
private fun FolderEditPreview() {
    KakaoTheme {
        FolderEditScreen()
    }
}
