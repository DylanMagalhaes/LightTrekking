package com.github.raziu75.lighttrekking.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.github.raziu75.lighttrekking.vm.StuffViewModel

@Composable
fun BodyStuff(modifier: Modifier, vm: StuffViewModel = viewModel(), navController: NavController) {
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
                value = stuffState.title,
                onValueChange = { newValue -> vm.onStuffNameInputChange(newValue) },
                label = { Text(text = "Nouveau Stuff") },
                trailingIcon = {
                    IconButton(onClick = { vm.onNewStuffClick() }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    }
                }
            )
        }
        Divider()
        if (stuffState.stuffList.isEmpty()) {
            Text(text = "Pas encore de stuff crée")
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(stuffState.stuffList) { stuff ->
                    StuffView(
                        stuff = stuff,
                        onDelete = { vm.onDeleteStuffClick(stuff) },
                        onClick = { navController.navigate("mainStuff") }
                    )
                }
            }
        }
    }
}


