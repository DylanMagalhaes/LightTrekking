package com.github.raziu75.lighttrekking.vm

import androidx.lifecycle.ViewModel
import com.github.raziu75.lighttrekking.model.Item
import com.github.raziu75.lighttrekking.model.Stuff
import com.github.raziu75.lighttrekking.ui.uiState.ItemState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ItemViewModel : ViewModel() {

    private val itemUiState = MutableStateFlow(ItemState())
    var uiState: StateFlow<ItemState> = itemUiState

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

    fun onAddItemClick() {
        if (itemUiState.value.itemName != "" && itemUiState.value.quantity != 0 && itemUiState.value.weight != 0.0) {
            val newStuff = Item(
                itemName = itemUiState.value.itemName,
                description = itemUiState.value.description,
                weight = itemUiState.value.weight,
                quantity = itemUiState.value.quantity
            )
            itemUiState.update { it.copy(itemList = it.itemList + newStuff) }
        }
        getTotalWeight()
    }

    fun onDeleteItemClick(item: Item) {
        itemUiState.update { currentState ->
            val updatedList = currentState.itemList.toMutableList()
            updatedList.remove(item)
            currentState.copy(itemList = updatedList)
        }
        getTotalWeight()
    }

    fun getTotalWeight() {
        val totalWeight = itemUiState.value.itemList.sumOf { it.weight * it.quantity }
        itemUiState.update { it.copy(totalWeight = totalWeight) }
    }

}