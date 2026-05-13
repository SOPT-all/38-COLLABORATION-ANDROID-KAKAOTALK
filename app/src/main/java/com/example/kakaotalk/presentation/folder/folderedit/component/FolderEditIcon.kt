package com.example.kakaotalk.presentation.folder.folderedit.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
            .then(
                if (isSelected) Modifier.border(2.dp, KakaoTheme.colors.gray800, CircleShape)
                else Modifier
            )
            .clip(shape = CircleShape)
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
fun FolderEditIconPreview(){
    KakaoTheme{
        Column() {
            FolderEditIcon(onClick = {}, isSelected = false)
            FolderEditIcon(onClick = {}, isSelected = true)
        }
    }
}