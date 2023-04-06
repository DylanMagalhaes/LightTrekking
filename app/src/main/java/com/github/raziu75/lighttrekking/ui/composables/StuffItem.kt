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
fun StuffItem(stuff: Stuff) {

    var stuffName by remember { mutableStateOf("Nouveau stuff") }
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = 200.dp,
        onClick = { }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(8.dp, 0.dp,0.dp,0.dp),
                text = stuffName)
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            }
        }
    }
}

