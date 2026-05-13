package com.example.kakaotalk.core.designsystem.component.KakakoChatProfile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

@Composable
fun KakaoChatRoomProfile(
    modifier : Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // 가운데 padding Spacer로 넣기엔 좀 애매해지는 것 같아서 ChatProfile 상에서 padding 넣는것으로 명시해줬습니다
            KakaoChatProfile(
                modifier = Modifier.padding(end = 2.dp),
                iconRes = R.drawable.ic_profile_blue_24
            )

            KakaoChatProfile(
                iconRes = R.drawable.ic_profile_blue_24
            )
        }
        
        Spacer(modifier = Modifier.padding(top = 2.dp))

        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            KakaoChatProfile(
                modifier = Modifier.padding(end = 2.dp),
                iconRes = R.drawable.ic_profile_light_blue_24
            )
            KakaoChatProfile(
                iconRes = R.drawable.ic_profile_deep_blue_24
            )
        }
    }
}

@Preview
@Composable
private fun KakakoChatRoomProfile() {
    KakaoTheme {
        KakaoChatRoomProfile()
    }
}
