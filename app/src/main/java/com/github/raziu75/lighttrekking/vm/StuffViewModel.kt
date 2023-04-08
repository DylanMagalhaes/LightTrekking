package com.github.raziu75.lighttrekking.vm

import androidx.lifecycle.ViewModel
import com.github.raziu75.lighttrekking.model.Stuff
import com.github.raziu75.lighttrekking.ui.uiState.StuffState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class StuffViewModel : ViewModel() {
    private val stuffUiState = MutableStateFlow(StuffState())

    var uiState: StateFlow<StuffState> = stuffUiState

    fun onStuffNameInputChange(value: String) {
        stuffUiState.update { it.copy(title = value) }
    }

    fun onNewStuffClick() {
        if (stuffUiState.value.title != "") {
            val newStuff = Stuff(stuffName = stuffUiState.value.title)
            stuffUiState.update { it.copy(stuffList = it.stuffList + newStuff, title = "") }
        }
    }

    fun onDeleteStuffClick(stuff: Stuff) {
        stuffUiState.update { currentState ->
            val updatedList = currentState.stuffList.toMutableList()
            updatedList.remove(stuff)
            currentState.copy(stuffList = updatedList)
        }
    }

}