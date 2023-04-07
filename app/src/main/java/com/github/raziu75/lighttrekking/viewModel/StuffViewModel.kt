package com.github.raziu75.lighttrekking.viewModel

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
        stuffUiState.update { it.copy(textFieldValue = value) }
    }

    fun onNewStuffClick() {
        if (stuffUiState.value.textFieldValue != "") {
            val newStuff = Stuff(stuffName = stuffUiState.value.textFieldValue)
            stuffUiState.update { it.copy(items = (it.items + newStuff) as MutableList<Stuff>, textFieldValue = "") }
        }
    }

    fun onDeleteStuffClick(stuff: Stuff) {
        stuffUiState.update { currentState ->
            val updatedList = currentState.items.toMutableList()
            updatedList.remove(stuff)
            currentState.copy(items = updatedList)
        }
    }

}