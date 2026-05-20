package com.example.kakaotalk.presentation.folder.folderedit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.core.designsystem.component.KakaoFolderItem
import com.example.kakaotalk.core.designsystem.component.KakaoTopAppBar
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme
import com.example.kakaotalk.presentation.folder.folderhome.component.KakaoFolderHeader
import com.example.kakaotalk.presentation.folder.foldermore.model.folderMoreList
import kotlinx.serialization.Serializable

@Serializable
data object FolderMore

@Composable
fun FolderMoreRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
) {
    FolderMoreScreen(
        onBackClick = navigateUp,
        modifier = Modifier.padding(paddingValues),
    )
}

@Composable
private fun FolderMoreScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(KakaoTheme.colors.white)
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 41.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        KakaoTopAppBar(
            modifier = Modifier,
            text = "채팅방 폴더 관리",
            onBackClick = onBackClick,
        )

        KakaoFolderHeader(
            modifier = Modifier,
            isMoreVisible = false,
        )

        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(13.dp),
        ){
            folderMoreList.forEachIndexed { index, folder ->
                KakaoFolderItem(
                    text = folder.title,
                    icon = folder.icon,
                )

                if (index != folderMoreList.lastIndex) {
                    HorizontalDivider(
                        modifier = Modifier,
                        thickness = 1.dp,
                        color = KakaoTheme.colors.gray100,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FolderMorePreview() {
    KakaoTheme {
        FolderMoreScreen(
            onBackClick = {}
        )
    }
}
