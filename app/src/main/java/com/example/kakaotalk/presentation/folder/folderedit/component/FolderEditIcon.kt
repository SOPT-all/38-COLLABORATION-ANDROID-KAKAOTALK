package com.example.kakaotalk.presentation.folder.folderedit.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

@Composable
fun FolderEditIcon(
    onClick: () -> Unit,
    isSelected: Boolean = false,
    @DrawableRes icon: Int = R.drawable.ic_edit_chunsik_24
){
    Box(
        modifier = Modifier
            .size(45.dp)
            .clip(shape = CircleShape)
            .let { if (isSelected) it.border(2.dp, KakaoTheme.colors.gray800, CircleShape) else it }
            .clickable(onClick = onClick)
            .background(color = KakaoTheme.colors.gray200),
        contentAlignment = Alignment.Center,
    ){
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.size(39.dp),
            tint = Color.Unspecified
        )
    }
}

@Preview
@Composable
private fun FolderEditIconPreview() {
    KakaoTheme {
        Column(
            modifier = Modifier.padding(vertical = 100.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                FolderEditIcon(onClick = {}, isSelected = true, icon = R.drawable.ic_no_exist_24)
                FolderEditIcon(onClick = {}, isSelected = false, icon = R.drawable.ic_edit_house_24)
                FolderEditIcon(onClick = {}, isSelected = false, icon = R.drawable.ic_edit_bag_24)
                FolderEditIcon(onClick = {}, isSelected = false, icon = R.drawable.ic_edit_heart_24)
                FolderEditIcon(onClick = {}, isSelected = false, icon = R.drawable.ic_edit_pencil_24)
                FolderEditIcon(onClick = {}, isSelected = true, icon = R.drawable.ic_edit_redbag_24)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                FolderEditIcon(onClick = {}, isSelected = false, icon = R.drawable.ic_edit_card_24)
                FolderEditIcon(onClick = {}, isSelected = false, icon = R.drawable.ic_edit_airplane_24)
                FolderEditIcon(onClick = {}, isSelected = false, icon = R.drawable.ic_edit_plus_24)
                FolderEditIcon(onClick = {}, isSelected = false, icon = R.drawable.ic_edit_chunsik_24)
                FolderEditIcon(onClick = {}, isSelected = false, icon = R.drawable.ic_edit_lion_24)
                FolderEditIcon(onClick = {}, isSelected = false, icon = R.drawable.ic_edit_jordi_24)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                FolderEditIcon(onClick = {}, isSelected = false, icon = R.drawable.ic_edit_cat_24)
                FolderEditIcon(onClick = {}, isSelected = false, icon = R.drawable.ic_edit_dog_24)
            }
        }
    }
}