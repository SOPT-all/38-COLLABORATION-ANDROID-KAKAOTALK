package com.example.kakaotalk.presentation.folder.folderedit.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
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
        onValueChange = { if (it.length <= 10) onValueChange(it) },
        textStyle = KakaoTheme.typography.body1.copy(color = KakaoTheme.colors.black),
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = true,
        decorationBox = { innerTextField ->
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "폴더 이름",
                        color = KakaoTheme.colors.black,
                        style = KakaoTheme.typography.body3
                    )

                    Spacer(modifier = Modifier.width(3.dp))

                    Icon(
                        painter = painterResource(R.drawable.ic_point_24),
                        contentDescription = null,
                        modifier = Modifier.size(9.dp),
                        tint = KakaoTheme.colors.orange300
                    )
                }

                Spacer(modifier = Modifier.height(22.dp))

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
