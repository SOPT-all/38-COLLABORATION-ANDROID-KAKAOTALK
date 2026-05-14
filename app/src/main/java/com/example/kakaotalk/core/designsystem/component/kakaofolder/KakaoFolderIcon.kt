package com.example.kakaotalk.core.designsystem.component.kakaofolder

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

@Composable
fun KakaoFolderIcon(
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier,
    iconColor: Color = Color.Unspecified
){
    Box(
        modifier = modifier
            .size(28.dp)
            .background(
                color = KakaoTheme.colors.gray200,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = iconColor
        )
    }
}

@Preview
@Composable
private fun KakaoFolderIconPreview(){
    KakaoTheme{
        Row(){
            Column(){
                KakaoFolderIcon(
                    icon = R.drawable.ic_gpt_24
                )

                Spacer(modifier = Modifier.height(2.dp))

                KakaoFolderIcon(
                    icon = R.drawable.ic_star_24,
                    iconColor = KakaoTheme.colors.orange200
                )
            }

            Spacer(modifier = Modifier.width(2.dp))

            Column(){
                KakaoFolderIcon(
                    icon = R.drawable.ic_edit_bag_24
                )

                Spacer(modifier = Modifier.height(2.dp))

                KakaoFolderIcon(
                    icon = R.drawable.ic_edit_pencil_24
                )
            }
        }

    }
}