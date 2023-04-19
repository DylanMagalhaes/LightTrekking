package com.github.raziu75.lighttrekking.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.raziu75.lighttrekking.model.Stuff

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun StuffView(
    stuff: Stuff,
    onDelete: () -> Unit,
    onClick: (Stuff) -> Unit,
) {
    Card(
        modifier = Modifier
            .clickable { onClick(stuff) }
            .fillMaxWidth()
            .padding(8.dp)
            .border(1.dp, MaterialTheme.colors.primaryVariant, MaterialTheme.shapes.medium)
            .clip(MaterialTheme.shapes.medium),
        shape = MaterialTheme.shapes.medium,
        elevation = 4.dp,
        onClick = { onClick(stuff) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stuff.stuffName,
                style = MaterialTheme.typography.h6,
            )
            Spacer(modifier = Modifier.weight(1.0F))
            IconButton(onClick = { onDelete() }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null,
                    tint = MaterialTheme.colors.error,
                )
            }
        }
    }
}
