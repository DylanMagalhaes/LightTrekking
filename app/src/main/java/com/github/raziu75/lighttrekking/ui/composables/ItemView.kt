package com.github.raziu75.lighttrekking.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.raziu75.lighttrekking.model.Item

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemView(
    item: Item,
    onDelete: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = 200.dp,
        onClick = { TODO() }
    ){
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(8.dp,0.dp,0.dp,0.dp),
                text = item.itemName
            )
            Text(
                modifier = Modifier.padding(8.dp,0.dp,0.dp,0.dp),
                text = "${ item.weight.toString() } Kg"
            )
            Text(
                modifier = Modifier.padding(8.dp,0.dp,0.dp,0.dp),
                text = "X ${item.quantity.toString()}"
            )
            Spacer(modifier = Modifier.weight(1.0F))
            IconButton(onClick = { onDelete()  }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null,
                    tint = MaterialTheme.colors.error)
            }
        }
    }
}