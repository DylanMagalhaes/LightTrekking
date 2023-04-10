package com.github.raziu75.lighttrekking.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import com.github.raziu75.lighttrekking.vm.ItemViewModel


@Composable
fun ClothesItemDetails(vm: ItemViewModel) {
    val itemState = vm.uiState.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally
        ) {
        ItemForm(vm)
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Poid Total: ${itemState.value.totalWeight} kg",
            fontWeight = FontWeight.Bold
            )
        Spacer(modifier = Modifier.height(10.dp))
        ListItemView(vm)
    }
}