package com.example.kakaotalk.presentation.chatlist

import com.example.kakaotalk.core.designsystem.theme.KakaoTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ChatListRoute(
    modifier: Modifier = Modifier
) {
    ChatListScreen(
        modifier = modifier
    )
}

@Composable
private fun ChatListScreen(
    modifier: Modifier = Modifier
) {

}


@Preview(showBackground = true)
@Composable
private fun ChatListPreview() {
    KakaoTheme {
        ChatListScreen()
    }
}
