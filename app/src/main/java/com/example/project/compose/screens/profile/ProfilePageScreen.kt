package com.example.project.compose.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.project.R
import com.example.project.auth.UserData
import com.example.project.compose.widgets.headers.StaticHeaderWidget
import com.example.project.ui.theme.Roboto

@Composable
fun ProfilePageScreen(
    userData: UserData?,
    onSignOut: () -> Unit,
    onBackClick: () -> Unit
) {
    Column {
        StaticHeaderWidget(
            text = stringResource(id = R.string.profile),
            imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
            onBackClick = onBackClick
        )
        if (userData?.profilePictureUrl != null && userData?.username != null) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 12.dp, vertical = 4.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Row {
                    AsyncImage(
                        model = userData.profilePictureUrl,
                        contentDescription = stringResource(id = R.string.profile),
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = userData.username,
                        fontFamily = Roboto,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight(700),
                        style = MaterialTheme.typography.body1,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(start = 10.dp, top = 3.dp)
                    )
                }
            }
        }
//        Button(onClick = onSignOut) {
//            Text(text = "Выйти")
//        }
    }
}