package com.example.kakaotalk.presentation.folder.folderedit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.designsystem.component.KakaoFolderItem
import com.example.kakaotalk.core.designsystem.component.KakaoTopAppBar
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme
import com.example.kakaotalk.presentation.folder.folderhome.DummyFolder
import com.example.kakaotalk.presentation.folder.folderhome.component.KakaoFolderHeader


@Composable
fun FolderMoreRoute(
    modifier: Modifier = Modifier
) {
    FolderMoreScreen(
        modifier = modifier
    )
}

@Composable
private fun FolderMoreScreen(
    modifier: Modifier = Modifier
        .background(KakaoTheme.colors.white)
        .fillMaxSize()
) {
    val dummyFolderList = listOf(
        DummyFolder(
            title = "ChatGPT",
            icon = R.drawable.ic_gpt_24
        ),
        DummyFolder(
            title = "즐겨찾기",
            icon = R.drawable.ic_star_24,
            iconColor = KakaoTheme.colors.orange200
        ),
        DummyFolder(
            title = "서울여자대학교",
            icon = R.drawable.ic_edit_pencil_24
        ),
        DummyFolder(
            title = "SOPT",
            icon = R.drawable.ic_edit_bag_24
        )
    )

    Column(
        modifier = modifier.padding(
            start = 16.dp,
            end = 16.dp
        ),

        ) {
        KakaoTopAppBar(
            modifier = Modifier.padding(top = 41.dp),
            text = "채팅방 폴더 관리",
            onBackClick = {}
        )

        KakaoFolderHeader(
            modifier = Modifier.padding(
                top = 24.dp,
                bottom = 24.dp
            ),
            isMoreVisible = false
        )

        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(13.dp)
        ){
            dummyFolderList.forEachIndexed { index, folder ->
                KakaoFolderItem(
                    text = folder.title,
                    icon = folder.icon,
                    iconColor = folder.iconColor,
                    onArrowClick = folder.onArrowClick
                )

                if (index != dummyFolderList.lastIndex) {
                    HorizontalDivider(
                        modifier = Modifier,
                        thickness = 1.dp,
                        color = KakaoTheme.colors.gray200
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
        FolderMoreScreen()
    }
}
