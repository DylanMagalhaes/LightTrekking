package com.github.raziu75.lighttrekking.model

data class Item(
    val itemName: String,
    val description: String,
    val weight: Double,
    val quantity: String,
    val categoryName: CategoryItem,
    val unitWeight: List<String> = listOf("kg", "g"),
    val selectedUnit: String,
)

