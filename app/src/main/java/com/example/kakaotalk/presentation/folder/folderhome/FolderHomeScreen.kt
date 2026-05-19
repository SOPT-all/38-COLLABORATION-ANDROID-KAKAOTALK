package com.example.kakaotalk.presentation.folder.folderhome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.designsystem.component.KakaoButton
import com.example.kakaotalk.core.designsystem.component.KakaoFolderItem
import com.example.kakaotalk.core.designsystem.component.KakaoTopAppBar
import com.example.kakaotalk.presentation.folder.folderhome.component.KakaoFolderHeader
import com.example.kakaotalk.presentation.folder.folderhome.model.folderHomeList
import com.example.kakaotalk.presentation.folder.folderhome.model.folderHomeNumberList

@Composable
fun FolderHomeRoute(
    modifier: Modifier = Modifier,
) {
    FolderHomeScreen(
        onMoreClick = {},
        onBackClick = {},
        onArrowClick = {},
        modifier = modifier
    )
}

@Composable
private fun FolderHomeScreen(
    onBackClick: () -> Unit,
    onMoreClick: () -> Unit,
    onArrowClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(KakaoTheme.colors.white)
            .fillMaxSize(),
    ){
        Column(
            modifier = Modifier
                .padding(top = 41.dp)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            KakaoTopAppBar(
                modifier = Modifier,
                text = "채팅방 폴더 관리",
                onBackClick = onBackClick,
            )

            KakaoFolderHeader(
                modifier = Modifier,
                onMoreClick = onMoreClick,
            )

            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(13.dp),
            ){
                folderHomeList.forEachIndexed { index, folder ->
                    KakaoFolderItem(
                        text = folder.title,
                        icon = folder.icon,
                    )

                    if (index != folderHomeList.lastIndex) {
                        HorizontalDivider(
                            modifier = Modifier.fillMaxWidth(),
                            thickness = 1.dp,
                            color = KakaoTheme.colors.gray100,
                        )
                    }
                }
            }
        }

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            thickness = 1.dp,
            color = KakaoTheme.colors.gray200,
        )

        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ){
            folderHomeNumberList.forEach { folder ->
                KakaoFolderItem(
                    text = folder.title,
                    icon = folder.icon,
                    isNumVisible = true,
                    folderCount = folder.folderCount,
                    onArrowClick = onArrowClick,
                )
            }

            KakaoButton(
                text = "폴더 만들기",
                modifier = Modifier,
                iconRes = R.drawable.ic_plus_24,
                textColor = KakaoTheme.colors.black,
                backgroundColor = KakaoTheme.colors.yellow500,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FolderHomePreview() {
    KakaoTheme {
        FolderHomeScreen(
            onMoreClick = {},
            onBackClick = {},
            onArrowClick = {},
        )
    }
}
