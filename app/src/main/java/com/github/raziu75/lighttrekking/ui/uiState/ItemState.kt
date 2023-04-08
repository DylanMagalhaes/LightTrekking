package com.github.raziu75.lighttrekking.ui.uiState

import com.github.raziu75.lighttrekking.model.Item

data class ItemState(

    val itemName: String ="",
    val description: String= "",
    val weight: Double? = null,
    val quantity: Int? = null,
    val CategoryName: List<String> = listOf("nourriture", "vetement", "accessoire", "autre")
)
