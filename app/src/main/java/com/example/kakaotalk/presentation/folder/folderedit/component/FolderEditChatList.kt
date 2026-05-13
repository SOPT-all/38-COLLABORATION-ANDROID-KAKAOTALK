package com.example.kakaotalk.presentation.folder.folderedit.component

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.designsystem.component.KakaoChatProfile.KakaoChatRoomProfile
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

@Composable
fun FolderEditChatList(
    chatName: String,
    peopleNum: Int,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            KakaoChatRoomProfile()

            Spacer(modifier = Modifier.width(9.dp))

            Text(
                text = chatName,
                color = KakaoTheme.colors.black,
                style = KakaoTheme.typography.body1
            )

            Spacer(modifier = Modifier.width(2.dp))

            Text(
                text = peopleNum.toString(),
                color = KakaoTheme.colors.gray600,
                style = KakaoTheme.typography.body1
            )
        }

        Icon(
            painter = painterResource(if(isSelected) R.drawable.ic_check_fill_24 else R.drawable.ic_check_default_24),
            contentDescription = null,
            tint = Color.Unspecified
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FolderEditChatListPreview(){
    KakaoTheme{
        Column {
            FolderEditChatList(
                chatName = "35기 SSARA 공지방",
                peopleNum = 24
            )

            FolderEditChatList(
                chatName = "[Let’s SOPT] 벋벋 17조",
                peopleNum = 7,
                isSelected = true
            )
        }
    }
}