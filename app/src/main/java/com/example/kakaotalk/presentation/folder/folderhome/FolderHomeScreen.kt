package com.example.kakaotalk.presentation.folder.folderhome

import com.example.kakaotalk.core.designsystem.theme.KakaoTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FolderHomeRoute(
    modifier: Modifier = Modifier
) {
    FolderHomeScreen(
        modifier = modifier
    )
}

@Composable
private fun FolderHomeScreen(
    modifier: Modifier = Modifier
) {

}


@Preview(showBackground = true)
@Composable
private fun FolderHomePreview() {
    KakaoTheme {
        FolderHomeScreen()
    }
}
