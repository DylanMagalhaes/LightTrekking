package com.github.raziu75.lighttrekking.ui.uiState

import com.github.raziu75.lighttrekking.model.Stuff

data class StuffState(
    val textFieldValue: String = "",
    val items: MutableList<Stuff> = mutableListOf()
)
