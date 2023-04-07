package com.github.raziu75.lighttrekking.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.raziu75.lighttrekking.model.Stuff

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun StuffItem(
    stuff: Stuff,
    onDelete: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = 200.dp,
        onClick = { TODO() }
    ){
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(8.dp,0.dp,0.dp,0.dp),
                text = stuff.stuffName
            )
            Spacer(modifier = Modifier.weight(1.0F))
            IconButton(onClick = { onDelete }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null,
                    tint = MaterialTheme.colors.error)
            }
        }
    }
}

