package com.github.raziu75.lighttrekking.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.raziu75.lighttrekking.model.CategoryItem
import com.github.raziu75.lighttrekking.vm.ItemViewModel


@Composable
fun ClothesItemDetails(vm: ItemViewModel, navController: NavController) {
    val itemState = vm.uiState.collectAsState()
    val selectedCategory = CategoryItem.CLOTHE
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ItemForm(vm, selectedCategory)
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Poids total: ${itemState.value.categoryTotalWeight[selectedCategory] ?: 0.0} kg",
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        ListItemView(vm, selectedCategory)
    }
}