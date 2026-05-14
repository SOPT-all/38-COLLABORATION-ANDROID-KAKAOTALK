package com.example.kakaotalk.presentation.folder.folderedit.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

@Composable
fun FolderEditTextField(
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    BasicTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        textStyle = KakaoTheme.typography.body1.copy(color = KakaoTheme.colors.black),
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
    )
}