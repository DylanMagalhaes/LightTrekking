package com.github.raziu75.lighttrekking.model

data class Item(
    val itemName: String,
    val description: String,
    val weight: String,
    val quantity: String,
    val categoryName: String,
    val unitWeight: List<String> = listOf("kg", "g")
)

