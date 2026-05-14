package com.example.kakaotalk.presentation.folder.folderedit.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.common.extension.noRippleClickable
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

@Composable
fun FolderSelectionItem(
    totalFolder: Int,
    selectedFolder: Int,
    onSelectClick: () -> Unit,
    onClearClick: () -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    backgroundColor: Color = KakaoTheme.colors.white
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor)
    ){
        Row(
            modifier = Modifier.align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painter = painterResource(
                    id = if (isSelected) R.drawable.ic_check_fill_24
                        else R.drawable.ic_check_default_24
                ),
                modifier = Modifier.noRippleClickable(onClick = onSelectClick),
                contentDescription = null,
                tint = Color.Unspecified,
            )

            Spacer(modifier = Modifier.width(3.dp))

            Text(
                text = "전체 선택",
                style = KakaoTheme.typography.body3
            )

            Spacer(modifier = Modifier.width(3.dp))

            Text(
                text = "(${selectedFolder}/${totalFolder})",
                style = KakaoTheme.typography.body3
            )
        }

        OutlinedButton(
            onClick = onClearClick,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .width(69.dp)
                .height(30.dp)
                .alpha(if (selectedFolder > 0) 1f else 0.5f),
            shape = RoundedCornerShape(999.dp),
            border = BorderStroke(1.dp, KakaoTheme.colors.gray300),
            contentPadding = PaddingValues()
        ) {
            Text(
                text = "선택 해제",
                color = KakaoTheme.colors.black,
                style = KakaoTheme.typography.body4
            )
        }
    }
}

@Preview
@Composable
private fun KaKaoFolderSelectionItemPreview(){
    Column() {
        FolderSelectionItem(
            totalFolder = 9,
            selectedFolder = 0,
            onSelectClick = {},
            onClearClick = {}
        )

        Spacer(modifier = Modifier.height(10.dp))

        FolderSelectionItem(
            totalFolder = 9,
            selectedFolder = 5,
            onSelectClick = {},
            onClearClick = {}
        )

        Spacer(modifier = Modifier.height(10.dp))

        FolderSelectionItem(
            totalFolder = 9,
            selectedFolder = 9,
            onSelectClick = {},
            onClearClick = {},
            isSelected = true
        )
    }
}