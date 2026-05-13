package com.example.kakaotalk.presentation.chatlist.component

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

sealed class MenuButtonType{
    data class menuDefaultType(val text: String) : MenuButtonType()
    object menuPlusType : MenuButtonType()
    data class menuNoreadType(var readNumber: Int) : MenuButtonType()
}
@Composable
fun ChatListMenuButton(
    menuButtonType: MenuButtonType,

) {

}

@Preview(showBackground = true)
@Composable
private fun ChatListMenuButtonPreview() {
    KakaoTheme {
        ChatListMenuButton()
    }
}

