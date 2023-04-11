package com.github.raziu75.lighttrekking.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.github.raziu75.lighttrekking.R
import com.github.raziu75.lighttrekking.model.ScreensName

@Composable
fun AppBar(
    screens: ScreensName,
    canGoBack: Boolean,
    up: () -> Unit
) {
    TopAppBar(
        title = { Text(text = if (canGoBack) screens.title else "Light Trekking") },
        navigationIcon = {
            if (canGoBack) {
                IconButton(onClick = up) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null)
                }
            } else {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                )
            }
        }
    )
}