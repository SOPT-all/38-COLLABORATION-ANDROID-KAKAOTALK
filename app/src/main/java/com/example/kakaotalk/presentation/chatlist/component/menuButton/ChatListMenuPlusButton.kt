package com.example.kakaotalk.presentation.chatlist.component.menuButton

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.common.extension.noRippleClickable
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

@Composable
fun ChatListMenuPlusButton(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    onSelected: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .size(40.dp)
            .background(
                color = if (isSelected) KakaoTheme.colors.black else KakaoTheme.colors.white,
                shape = CircleShape
            )
            .border(
                width = 1.dp,
                color = if (isSelected) KakaoTheme.colors.black else KakaoTheme.colors.gray300,
                shape = CircleShape
            )
            .noRippleClickable(onClick = onSelected),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_foler_plus_24),
            contentDescription = "Chat List Menu Plus Button",
            tint = Color.Unspecified
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ChatListMenuPlusButtonPreview() {
    KakaoTheme {
        ChatListMenuPlusButton()
    }
}
