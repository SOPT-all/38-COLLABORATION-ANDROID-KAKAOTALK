package com.example.kakaotalk.presentation.chatlist.component.menuButton

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

@Composable
fun NumOfChat(
    number: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(16.dp)
            .background(
                color = KakaoTheme.colors.orange300,
                shape = RoundedCornerShape(30.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$number",
            modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp),
            color = KakaoTheme.colors.white,
            style = KakaoTheme.typography.body6
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NumOfChatPreview() {
    KakaoTheme {
        Row() {
            NumOfChat(1)

            Spacer(modifier = Modifier.width(1.dp))

            NumOfChat(12)
        }
    }
}
