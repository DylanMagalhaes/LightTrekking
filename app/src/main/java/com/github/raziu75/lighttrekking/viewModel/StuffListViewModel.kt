package com.github.raziu75.lighttrekking.viewModel

import androidx.lifecycle.ViewModel
import com.github.raziu75.lighttrekking.model.Stuff
import com.github.raziu75.lighttrekking.ui.uiState.StuffState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class StuffListViewModel : ViewModel() {
    private val stuffUiState = MutableStateFlow(StuffState())

    var uiState: StateFlow<StuffState> = stuffUiState

    fun addStuff() {
        val newStuff = Stuff()
        stuffUiState.update { it.copy(items = (it.items + newStuff) as MutableList<Stuff>, textFieldValue = "") }
    }


}