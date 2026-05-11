package com.example.kakaotalk.presentation.folder.foldermore

import com.example.kakaotalk.core.designsystem.theme.KakaoTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FolderMoreRoute(
    modifier: Modifier = Modifier
) {
    FolderMoreScreen(
        modifier = modifier
    )
}

@Composable
private fun FolderMoreScreen(
    modifier: Modifier = Modifier
) {

}


@Preview(showBackground = true)
@Composable
private fun FolderMorePreview() {
    KakaoTheme {
        FolderMoreScreen()
    }
}
