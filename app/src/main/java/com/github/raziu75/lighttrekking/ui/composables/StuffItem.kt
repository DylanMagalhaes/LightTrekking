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
import com.github.raziu75.lighttrekking.viewModel.StuffListViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun StuffItem(stuff: Stuff, vm: StuffListViewModel, onDelet: () -> Unit) {

    var stuffName by remember { mutableStateOf("Nouveau stuff") }
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = 200.dp,
        onClick = { vm.deleteStuff(stuff = stuff) }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(8.dp, 0.dp,0.dp,0.dp),
                text = stuffName)
            IconButton(onClick = {  onDelet()}) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            }
        }
    }
}

