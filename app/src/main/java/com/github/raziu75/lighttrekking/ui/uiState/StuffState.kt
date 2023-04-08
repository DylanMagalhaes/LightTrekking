package com.github.raziu75.lighttrekking.ui.uiState

import com.github.raziu75.lighttrekking.model.Stuff

data class StuffState(
    val title: String = "",
    val items: List<Stuff> = listOf()
)
