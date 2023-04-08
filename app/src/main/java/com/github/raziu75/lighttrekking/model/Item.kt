package com.github.raziu75.lighttrekking.model

data class Item(
    val itemName: String,
    val description: String,
    val weight: Double?,
    val quantity: Int?,
    val items: List<String>
)
