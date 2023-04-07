package com.github.raziu75.lighttrekking.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.raziu75.lighttrekking.model.Stuff
import com.github.raziu75.lighttrekking.viewModel.StuffListViewModel

@Composable
fun HomePage(vm: StuffListViewModel = viewModel()) {
    val state by vm.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        LazyColumn(modifier = Modifier) {
            items(state.items) { stuff ->
                StuffItem(stuff = Stuff(), vm = StuffListViewModel(), onDelet = { vm.deleteStuff(stuff = stuff) })
            }
        }
        IconButton(onClick = { vm.addStuff() }) {
            Row() {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
                Text(text = "Ajouter une Liste")
            }
        }
    }

}


