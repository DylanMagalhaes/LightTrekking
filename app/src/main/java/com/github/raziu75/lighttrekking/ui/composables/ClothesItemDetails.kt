package com.github.raziu75.lighttrekking.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ClothesItemDetails() {
    Column {
        ItemForm()
        Spacer(modifier = Modifier.height(20.dp))
        ListItemView()
    }
}