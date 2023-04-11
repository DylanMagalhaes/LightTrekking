package com.github.raziu75.lighttrekking.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme

import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.raziu75.lighttrekking.ui.uiState.ItemState
import com.github.raziu75.lighttrekking.vm.ItemViewModel


@Composable
fun ClothesItemDetails(vm: ItemViewModel, navController: NavController) {
    val itemState = vm.uiState.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Button(onClick = { navController.popBackStack() }) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
        }
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