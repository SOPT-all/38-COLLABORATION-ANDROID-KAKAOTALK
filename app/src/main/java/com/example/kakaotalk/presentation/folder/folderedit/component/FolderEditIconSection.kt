package com.example.kakaotalk.presentation.folder.folderedit.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme
import com.example.kakaotalk.presentation.folder.folderedit.model.iconList

@Composable
fun FolderEditIconSection(
    onIconClick: (Int) -> Unit,
    selectedIcon: Int?,
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier
    ) {
        Text(
            text = "폴더 아이콘",
            color = KakaoTheme.colors.gray900,
            style = KakaoTheme.typography.body3
        )

        Spacer(modifier = Modifier.height(24.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(6),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(iconList) { icon ->
                FolderEditIcon(
                    modifier = Modifier.aspectRatio(1f),
                    onIconClick = { onIconClick(icon) },
                    isSelected = icon == selectedIcon,
                    icon = icon
                )
            }
        }
    }
}

@Preview
@Composable
private fun FolderEditIconSectionPreview(){
    KakaoTheme{
        FolderEditIconSection(
            onIconClick = {},
            selectedIcon = null
        )
    }
}