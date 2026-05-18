package com.example.kakaotalk.presentation.folder.folderedit.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

private val iconList = listOf(
    R.drawable.ic_no_exist_24,
    R.drawable.ic_edit_house_24,
    R.drawable.ic_edit_bag_24,
    R.drawable.ic_edit_heart_24,
    R.drawable.ic_edit_pencil_24,
    R.drawable.ic_edit_redbag_24,
    R.drawable.ic_edit_card_24,
    R.drawable.ic_edit_airplane_24,
    R.drawable.ic_edit_plus_24,
    R.drawable.ic_edit_chunsik_24,
    R.drawable.ic_edit_lion_24,
    R.drawable.ic_edit_jordi_24,
    R.drawable.ic_edit_cat_24,
    R.drawable.ic_edit_dog_24,
)

@Composable
fun FolderIconSection(
    onIconClick: () -> Unit,
    isIconSelected: Boolean = false,
){
    LazyVerticalGrid(
        columns = GridCells.Fixed(6),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(iconList) { icon ->
            FolderEditIcon(
                onClick = onIconClick,
                isSelected = isIconSelected,
                icon = icon
            )
        }
    }
}

@Preview
@Composable
private fun FolderIconSectionPreview(){
    KakaoTheme{
        FolderIconSection(
            onIconClick = {},
        )
    }
}