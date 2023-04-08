package com.github.raziu75.lighttrekking.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.github.raziu75.lighttrekking.model.Item
import com.github.raziu75.lighttrekking.ui.uiState.ItemState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ItemViewModel : ViewModel() {

    private val itemUiState = MutableStateFlow(ItemState())
    var uiState: StateFlow<ItemState> = itemUiState

   //// fun onCategoryNameInputChange(value: List<String>) {
   ////     itemUiState.update { it.copy(categoryName = value) }
   //// }

    fun onItemNameInputChange(value: String) {
        itemUiState.update { it.copy(itemName = value) }
    }

    fun onDescriptionInputChange(value: String) {
        itemUiState.update { it.copy(description = value) }
    }

    fun onWeightInputChange(value: Double) {
        itemUiState.update { it.copy(weight = value) }
    }

    fun onQuantityInputChange(value: Int) {
        itemUiState.update { it.copy(quantity = value) }
    }

   // fun onNewItemClick() {
   //         val newItem = Item("", "", "", null, null)
   //         itemUiState.update { it.copy(itemList = it.itemList + newItem) }
//
   // }
}