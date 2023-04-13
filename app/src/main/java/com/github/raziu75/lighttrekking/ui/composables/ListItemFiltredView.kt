package com.github.raziu75.lighttrekking.ui.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.raziu75.lighttrekking.model.CategoryItem
import com.github.raziu75.lighttrekking.vm.ItemViewModel

@Composable
fun ListItemFilteredView(
    vm: ItemViewModel = viewModel(),
    selectedCategory: CategoryItem
) {
    val itemState by vm.uiState.collectAsState()

    val filteredItems = itemState.itemList.filter { it.categoryName == selectedCategory }
    if (filteredItems.isEmpty()) {
        Text(text = "La liste est vide ")
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(filteredItems) { item ->
                ItemView(
                    item = item,
                    onDelete = { vm.onDeleteItemClick(item) },
                )
            }
        }
    }
}
