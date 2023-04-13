package com.github.raziu75.lighttrekking.ui.uiState

import com.github.raziu75.lighttrekking.model.CategoryItem
import com.github.raziu75.lighttrekking.model.Item

data class ItemState(

    val itemName: String = "",
    val description: String = "",
    val weight: String = "",
    val quantity: String = "",
    val unitWeight: List<String> = listOf("kg", "g"),
    val itemList: List<Item> = listOf(),
    var totalWeight: Double = 0.0,
    val categoryName: CategoryItem = CategoryItem.CLOTHE,
    val categoryTotalWeight: Map<CategoryItem, Double> = emptyMap()
)
