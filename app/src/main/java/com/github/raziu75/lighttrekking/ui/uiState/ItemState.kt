package com.github.raziu75.lighttrekking.ui.uiState

data class ItemState(

    val itemName: String ="",
    val description: String= "",
    val weight: Double = 0.0,
    val quantity: Int = 0,
    val unitWeight: List<String> = listOf("kg", "g")
)
