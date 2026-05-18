package com.example.kakaotalk.presentation.folder.folderedit

import com.example.kakaotalk.core.designsystem.theme.KakaoTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FolderEditRoute(
    modifier: Modifier = Modifier
) {
    FolderEditScreen(
        modifier = modifier
    )
}

@Composable
private fun FolderEditScreen(
    modifier: Modifier = Modifier
) {

}


@Preview(showBackground = true)
@Composable
private fun FolderEditPreview() {
    KakaoTheme {
        FolderEditScreen()
    }
}