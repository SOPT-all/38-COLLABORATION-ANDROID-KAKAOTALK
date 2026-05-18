package com.example.kakaotalk.presentation.folder.folderhome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.designsystem.component.KakaoButton
import com.example.kakaotalk.core.designsystem.component.KakaoFolderItem
import com.example.kakaotalk.core.designsystem.component.KakaoTopAppBar
import com.example.kakaotalk.presentation.folder.folderhome.component.KakaoFolderHeader

@Composable
fun FolderHomeRoute(
    modifier: Modifier = Modifier
) {
    FolderHomeScreen(
        modifier = modifier
    )
}

@Composable
private fun FolderHomeScreen(
    modifier: Modifier = Modifier
        .background(KakaoTheme.colors.white)
        .fillMaxSize()
) {
    val dummyFolderList = listOf(
        DummyFolder(
            title = "기계",
            icon = R.drawable.ic_folder_24,
            folderCount = 9,
            onArrowClick = {}
        ),

        DummyFolder(
            title = "서울여자대학교",
            icon = R.drawable.ic_edit_pencil_24,
            folderCount = 11,
            onArrowClick = {}
        ),

        DummyFolder(
            title = "SOPT",
            icon = R.drawable.ic_edit_bag_24,
            folderCount = 3,
            onArrowClick = {}
        )
    )

    Column(
        modifier = modifier
    ){

        Column(
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp
            )
        ) {
            KakaoTopAppBar(
                modifier = Modifier.padding(top = 41.dp),
                text = "채팅방 폴더 관리",
                onBackClick = {},               // onClick!!!!

            )

            KakaoFolderHeader(
                modifier = Modifier.padding(top = 24.dp),
                onMoreClick = {}                // onclick!!!!
            )

            Column(
                modifier = Modifier.padding(top = 24.dp),
                verticalArrangement = Arrangement.spacedBy(13.dp)
            ){
                KakaoFolderItem(
                    text = "ChatGPT",
                    icon = R.drawable.ic_gpt_24
                )

                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 1.dp,
                    color = KakaoTheme.colors.gray200
                )

                KakaoFolderItem(
                    text = "즐겨찾기",
                    icon = R.drawable.ic_star_24,
                    iconColor = KakaoTheme.colors.orange200
                )
            }
        }

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            thickness = 1.dp,
            color = KakaoTheme.colors.gray200
        )

        Column(
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp
            )
        ){
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ){
                dummyFolderList.forEachIndexed { index, folder ->
                    KakaoFolderItem(
                        text = folder.title,
                        icon = folder.icon,
                        iconColor = folder.iconColor,
                        isNumVisible = true,
                        folderCount = folder.folderCount,
                        onArrowClick = folder.onArrowClick
                    )
                }
            }

            KakaoButton(
                text = "폴더 만들기",
                modifier = Modifier.padding(top = 24.dp),
                iconRes = R.drawable.ic_plus_24,
                textColor = KakaoTheme.colors.black,
                backgroundColor = KakaoTheme.colors.yellow500
            )
        }
    }
}

data class DummyFolder(
    val title: String,
    val icon: Int,
    val iconColor: Color = Color.Unspecified,
    val folderCount: Int = 0,
    val onArrowClick: () -> Unit = {}
)

@Preview(showBackground = true)
@Composable
private fun FolderHomePreview() {
    KakaoTheme {
        FolderHomeScreen()
    }
}
