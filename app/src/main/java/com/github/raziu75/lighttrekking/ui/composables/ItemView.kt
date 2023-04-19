package com.github.raziu75.lighttrekking.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
            .padding(8.dp)
            .clip(MaterialTheme.shapes.medium)
            .border(1.dp, MaterialTheme.colors.primaryVariant, MaterialTheme.shapes.medium),
        shape = MaterialTheme.shapes.medium,
        elevation = 4.dp,
        onClick = { TODO() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = item.itemName,
                style = MaterialTheme.typography.h6,
            )
            Text(
                text = "${item.weight} ${item.selectedUnit}",
                style = MaterialTheme.typography.subtitle1,
                color = Color.Gray,
            )
            Text(
                text = "X ${item.quantity}",
                style = MaterialTheme.typography.subtitle1,
                color = Color.Gray,
            )
            IconButton(onClick = { onDelete() }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null,
                    tint = MaterialTheme.colors.error,
                )
            }
        }
    }
}
