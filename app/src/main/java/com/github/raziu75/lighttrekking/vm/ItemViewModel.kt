package com.github.raziu75.lighttrekking.vm

import androidx.lifecycle.ViewModel
import com.github.raziu75.lighttrekking.model.CategoryItem
import com.github.raziu75.lighttrekking.model.Item
import com.github.raziu75.lighttrekking.ui.uiState.ItemState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlin.math.round

class ItemViewModel : ViewModel() {

    private val itemUiState = MutableStateFlow(ItemState())
    var uiState: StateFlow<ItemState> = itemUiState

    fun onItemNameInputChange(value: String) {
        itemUiState.update { it.copy(itemName = value) }
    }

    fun onDescriptionInputChange(value: String) {
        itemUiState.update { it.copy(description = value) }
    }

    fun onWeightInputChange(value: String) {
        itemUiState.update { it.copy(weight = value) }
    }

    fun onQuantityInputChange(value: String) {
        itemUiState.update { it.copy(quantity = value) }
    }

    fun onAddItemClick(category: CategoryItem) {
        if (itemUiState.value.itemName != "" && itemUiState.value.quantity != "" && itemUiState.value.weight != "") {
            val weightInKg = if (itemUiState.value.selectedUnit == 0) {
                itemUiState.value.weight.toDouble()
            } else {
                itemUiState.value.weight.toDouble() / 1000
            }
            val newStuff = Item(
                itemName = itemUiState.value.itemName,
                description = itemUiState.value.description,
                weight = weightInKg,
                quantity = itemUiState.value.quantity,
                categoryName = category,
                selectedUnit = itemUiState.value.unitWeight[itemUiState.value.selectedUnit]
            )
            itemUiState.update { it.copy(itemList = it.itemList + newStuff) }
        }
        getTotalWeight()
    }

    fun updateSelectedUnit(selectedUnit: Int) {
        itemUiState.update { it.copy(selectedUnit = selectedUnit) }
    }

    fun onDeleteItemClick(item: Item) {
        itemUiState.update { currentState ->
            val updatedList = currentState.itemList.toMutableList()
            updatedList.remove(item)
            currentState.copy(itemList = updatedList)
        }
        getTotalWeight()
    }


    private fun getTotalWeight() {
        val totalWeight =
            itemUiState.value.itemList.sumOf { it.weight.toDouble() * it.quantity.toInt() }

        val categoryTotalWeight = itemUiState.value.itemList.groupBy { it.categoryName }
            .mapValues { (_, items) -> items.sumOf { it.weight.toDouble() * it.quantity.toInt() } }

        val roundedTotalWeight = round(totalWeight * 100) / 100
        val roundedCategoryTotalWeight =
            categoryTotalWeight.mapValues { (_, value) -> round(value * 100) / 100 }

        itemUiState.update {
            it.copy(
                totalWeight = roundedTotalWeight,
                categoryTotalWeight = roundedCategoryTotalWeight
            )
        }
    }
}
