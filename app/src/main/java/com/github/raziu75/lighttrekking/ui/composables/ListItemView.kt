package com.github.raziu75.lighttrekking.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.github.raziu75.lighttrekking.vm.ItemViewModel

@Composable
fun ListItemView(
    vm: ItemViewModel = viewModel(),
    navController: NavHostController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val itemState by vm.uiState.collectAsState()

        val Items = itemState.itemList
        if (Items.isEmpty()) {
            Text(text = "La liste est vide ")
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(Items) { item ->
                    ItemView(
                        item = item,
                        onDelete = { vm.onDeleteItemClick(item) },
                    )
                }
            }
        }
    }
}