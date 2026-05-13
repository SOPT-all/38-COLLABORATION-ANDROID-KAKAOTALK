package com.example.kakaotalk.core.designsystem.component.KakakoChatProfile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaotalk.R
import com.example.kakaotalk.core.designsystem.theme.KakaoTheme

@Composable
fun KakaoChatRoomProfile(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.size(48.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            KakaoChatProfile(
                iconRes = R.drawable.ic_profile_blue_24
            )

            KakaoChatProfile(
                iconRes = R.drawable.ic_profile_blue_24
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            KakaoChatProfile(
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
private fun KakaoChatRoomProfilePreview() {
    KakaoTheme {
        KakaoChatRoomProfile()
    }
}
