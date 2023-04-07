package com.github.raziu75.lighttrekking.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.raziu75.lighttrekking.viewModel.StuffViewModel

@Composable
fun BodyStuff(modifier: Modifier, vm: StuffViewModel = viewModel()) {
    val stuffState by vm.uiState.collectAsState()
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Surface(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = stuffState.textFieldValue,
                onValueChange = { newValue -> vm.giveName(newValue)},
                label = { Text(text = "Nouveau Stuff") },
                trailingIcon = {
                    IconButton(onClick = { vm.OnNewStuffClick() }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    }
                }
            )
        }
        Divider()
        if (stuffState.items.isEmpty()) {
            Text(text = "Pas encore de stuff crée")
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(stuffState.items) { stuff ->
                    StuffItem(
                        stuff = stuff,
                        onDelete = { vm.onDeleteStuffClick(stuff)}
                    )
                }
            }
        }
    }
}


