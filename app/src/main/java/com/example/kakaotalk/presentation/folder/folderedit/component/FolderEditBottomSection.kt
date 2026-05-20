package com.example.kakaotalk.presentation.folder.folderedit.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme
import com.example.kakaotalk.presentation.folder.folderedit.model.folderEditChatList

@Composable
fun FolderEditBottomSection(
    totalChatCount: Int,
    selectedChatCount: Int,
    selectedChatIds: Set<String>,
    onSelectAllClick: () -> Unit,
    onDeleteSelectedClick: () -> Unit,
    onChatClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    isAllChatSelected: Boolean = false
){
    Column(modifier = modifier) {
        KakaoFolderSelectItem(
            totalFolder = totalChatCount,
            selectedFolder = selectedChatCount,
            onSelectClick = onSelectAllClick,
            onClearClick = onDeleteSelectedClick,
            isSelected = isAllChatSelected
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .border(
                                width = 1.dp,
                                color = KakaoTheme.colors.gray300,
                                shape = RoundedCornerShape(15.dp)
                            )
                            .background(color = KakaoTheme.colors.gray100)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_plus_24),
                            contentDescription = null,
                            modifier = Modifier.align(Alignment.Center),
                            tint = KakaoTheme.colors.gray900
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = "채팅방 추가",
                        color = KakaoTheme.colors.black,
                        style = KakaoTheme.typography.body3
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
            }

            items(folderEditChatList, key = { it.id })
            { chatlist ->
                FolderEditChatList(
                    chatName = chatlist.chatName,
                    peopleNum = chatlist.peopleNum,
                    isSelected = chatlist.id in selectedChatIds,
                    onClick = { onChatClick(chatlist.id) }
                )
            }
        }
    }
}