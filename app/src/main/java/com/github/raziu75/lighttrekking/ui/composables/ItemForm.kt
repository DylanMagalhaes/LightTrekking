package com.github.raziu75.lighttrekking.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.raziu75.lighttrekking.vm.ItemViewModel

@Composable
fun ItemForm(vm: ItemViewModel = viewModel()) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val screen4 = screenWidth / 4
    val screen2 = screenWidth / 2
    val screen7 = screenWidth / 7
    val itemState = vm.uiState.collectAsState()
    var expanded by remember { mutableStateOf(false) }
    var selectedUnit by remember { mutableStateOf(0) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            // horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextField(
                modifier = Modifier.width(screen2.dp),
                value = itemState.value.itemName,
                onValueChange = { newValue -> vm.onItemNameInputChange(newValue) },
                placeholder = { Text(text = "Nom") }
            )
            Spacer(modifier = Modifier.width(1.dp))
            TextField(
                modifier = Modifier.width(screen2.dp),
                value = itemState.value.description,
                onValueChange = { newValue -> vm.onDescriptionInputChange(newValue) },
                placeholder = { Text(text = "Déscription") }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Poid: ")
            TextField(
                modifier = Modifier.width(screen4.dp),
                value = itemState.value.weight.toString(),
                onValueChange = { newValue -> vm.onWeightInputChange(newValue.toDouble()) },
                placeholder = { Text(text = "Poid") }
            )
            Box(
                modifier = Modifier
                    .height(25.dp)
                    //.background(Color.LightGray)
                    .clickable(onClick = { expanded = !expanded })
            ) {
                Row() {
                    Text(
                        text = itemState.value.unitWeight[selectedUnit],
                        modifier = Modifier.padding(bottom = 4.dp, start = 2.dp)
                    )
                    Icon(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier.padding(0.dp)
                    )
                }

            }
            if (expanded) {
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                ) {
                    itemState.value.unitWeight.forEachIndexed { index, text ->
                        if (index != selectedUnit) {
                            DropdownMenuItem(
                                onClick = {
                                    selectedUnit = index
                                    expanded = false
                                }
                            ) {
                                Text(
                                    text = text,
                                    modifier = Modifier.padding(8.dp)
                                )
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.width(1.dp))
            Text(text = "Quantité: ")
            TextField(
                modifier = Modifier.width(screen7.dp),
                value = itemState.value.quantity.toString(),
                onValueChange = { newValue -> vm.onQuantityInputChange(newValue.toInt()) },
                placeholder = { Text(text = "Quantité") }
            )
        }
        Button(onClick = {vm.onAddItemClick()}) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
            Text(text = "Ajouter a la liste",Modifier.padding(start = 10.dp))
        }
    }
}




