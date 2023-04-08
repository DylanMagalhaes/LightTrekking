package com.github.raziu75.lighttrekking.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.github.raziu75.lighttrekking.vm.ItemViewModel

@Composable
fun BodyItem(vm: ItemViewModel) {

    val itemState by vm.uiState.collectAsState()
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }


    Column(modifier = Modifier.fillMaxSize()) {
        Divider(
            modifier = Modifier.fillMaxWidth(), color = Color.Black
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {

            Box(
                modifier = Modifier
                   // .padding(16.dp)
                    .background(Color.LightGray)
                    .clickable(onClick = { expanded = !expanded })
            ) {
                Row(){
                    Text(
                        text = itemState.CategoryName[selectedIndex],
                        modifier = Modifier.padding(8.dp)
                    )
                    Icon(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier.padding(8.dp)
                    )
                }

            }
            if (expanded) {
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                ) {
                    itemState.CategoryName.forEachIndexed { index, text ->
                        if (index != selectedIndex) {
                            DropdownMenuItem(
                                onClick = {
                                    selectedIndex = index
                                    expanded = false
                                }
                            ) {
                                Text(
                                    text = text,
                                    modifier = Modifier.padding(16.dp)
                                )
                            }
                        }
                    }
                }
            }
            Text(
                text = "Poid",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Quantité",
                fontWeight = FontWeight.Bold
            )
        }
        Divider(
            modifier = Modifier.fillMaxWidth(), color = Color.Black
        )
        itemView()
    }
}
