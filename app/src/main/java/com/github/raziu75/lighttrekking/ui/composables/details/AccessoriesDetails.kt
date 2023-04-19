package com.github.raziu75.lighttrekking.ui.composables.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.raziu75.lighttrekking.model.CategoryItem
import com.github.raziu75.lighttrekking.ui.composables.ItemForm
import com.github.raziu75.lighttrekking.ui.composables.ListItemFilteredView
import com.github.raziu75.lighttrekking.vm.ItemViewModel

@Composable
fun AccessoriesDetails(vm: ItemViewModel, navController: NavController) {
    val itemState = vm.uiState.collectAsState()
    val selectedCategory = CategoryItem.ACCESSORY
    var showItemForm by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize().padding(bottom = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (showItemForm) {
                ItemForm(vm, selectedCategory)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Poids total: ${itemState.value.categoryTotalWeight[selectedCategory] ?: 0.0} kg",
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            ListItemFilteredView(vm, selectedCategory = selectedCategory)
        }
        FloatingActionButton(
            onClick = { showItemForm = !showItemForm },
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.BottomCenter)
        ) {
            if (showItemForm) {
                Icon(Icons.Filled.Close, contentDescription = null)
            } else {
                Icon(Icons.Filled.Add, contentDescription = null)
            }
        }
    }
}
