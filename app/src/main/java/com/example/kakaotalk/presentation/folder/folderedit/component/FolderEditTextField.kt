package com.example.kakaotalk.presentation.folder.folderedit.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

@Composable
fun FolderEditTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    BasicTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        textStyle = KakaoTheme.typography.body1.copy(color = KakaoTheme.colors.black),
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = true,
        decorationBox = { innerTextField ->
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                innerTextField()

                Spacer(modifier = Modifier.height(11.dp))

                HorizontalDivider(
                    thickness = 1.dp,
                    color = KakaoTheme.colors.gray400
                )

                Spacer(modifier = Modifier.height(7.dp))

                Text(
                    modifier = Modifier.align(Alignment.End),
                    text = "${value.length}/10",
                    style = KakaoTheme.typography.body3,
                    color = KakaoTheme.colors.gray600,
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun FolderEditTextFieldPreview() {
    KakaoTheme {
        var text by remember { mutableStateOf("폴더 이름") }

        FolderEditTextField(
            value = text,
            onValueChange = { text = it },
        )
    }
}
