package com.example.kakaotalk.core.designsystem.component

import android.R.attr.description
import android.R.attr.onClick
import android.R.attr.textColor
import android.R.attr.type
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

@Composable
fun KakaoModal(
    title: String,
    description: String,
    cancelText: String,
    confirmText: String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
){
    Dialog(
        onDismissRequest = onDismiss,
        properties =
            DialogProperties(
                usePlatformDefaultWidth = false,
                decorFitsSystemWindows = false,
            )
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment = Alignment.Center,
        ){
            Column(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .background(
                            color = KakaoTheme.colors.white,
                            shape = RoundedCornerShape(24.dp),
                        )
                        .padding(all = 16.dp),
            ) {
                Text(
                    text = title,
                    color = KakaoTheme.colors.black,
                    style = KakaoTheme.typography.head1
                )

                Spacer(Modifier.height(4.dp))

                Text(
                    text = description,
                    color = KakaoTheme.colors.black,
                    style = KakaoTheme.typography.body1
                )

                Spacer(Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    KakaoModalButton(
                        text = cancelText,
                        backgroundColor = KakaoTheme.colors.yellow400,
                        onClick = onDismiss,
                        modifier = Modifier.weight(1f),
                    )
                    KakaoModalButton(
                        text = confirmText,
                        backgroundColor = KakaoTheme.colors.yellow500,
                        onClick = onConfirm,
                        modifier = Modifier.weight(1f),
                    )
                }
            }
        }
    }
}

@Composable
private fun KakaoModalButton(
    text: String,
    backgroundColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .clip(RoundedCornerShape(50.dp))
            .background(backgroundColor)
            .padding(vertical = 8.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            style = KakaoTheme.typography.body2,
            color = KakaoTheme.colors.gray900,
        )
    }
}

@Preview
@Composable
private fun KakaoModalPreview() {
    KakaoTheme{
        Column{
            KakaoModal(
                title = "채팅방 폴더 삭제",
                description = "폴더를 삭제하시겠습니까? 폴더가 삭제되어도 채팅방은 나가기 되지 않습니다.",
                cancelText = "취소",
                confirmText = "삭제",
                onConfirm = {},
                onDismiss = {},
            )
        }
    }
}