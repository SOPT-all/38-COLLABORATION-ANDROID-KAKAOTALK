package com.example.kakaotalk.presentation.folder.folderedit.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.common.extension.noRippleClickable
import com.example.kakaotalk.core.designsystem.component.KakaoRoundedButton
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

@Composable
fun KakaoFolderSelectItem(
    totalFolder: Int,
    selectedFolder: Int,
    onSelectClick: () -> Unit,
    onClearClick: () -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painter = painterResource(id = if (isSelected) R.drawable.ic_check_fill_24 else R.drawable.ic_check_default_24),
                modifier = Modifier.noRippleClickable(onClick = onSelectClick),
                contentDescription = null,
                tint = Color.Unspecified,
            )

            Text(
                text = "전체 선택",
                style = KakaoTheme.typography.body3,
                color = KakaoTheme.colors.gray900
            )

            Text(
                text = "(${selectedFolder}/${totalFolder})",
                style = KakaoTheme.typography.body3,
                color = KakaoTheme.colors.gray900
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        KakaoRoundedButton(
            text = "선택 해제",
            onClick = onClearClick,
            isClickable = selectedFolder > 0
        )
    }
}

@Preview (showBackground = true)
@Composable
private fun KaKaoKakaoFolderSelectItemPreview(){
    Column() {
        KakaoFolderSelectItem(
            totalFolder = 9,
            selectedFolder = 0,
            onSelectClick = {},
            onClearClick = {}
        )

        Spacer(modifier = Modifier.height(10.dp))

        KakaoFolderSelectItem(
            totalFolder = 9,
            selectedFolder = 5,
            onSelectClick = {},
            onClearClick = {}
        )

        Spacer(modifier = Modifier.height(10.dp))

        KakaoFolderSelectItem(
            totalFolder = 9,
            selectedFolder = 9,
            onSelectClick = {},
            onClearClick = {},
            isSelected = true
        )
    }
}