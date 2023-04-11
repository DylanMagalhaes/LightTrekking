package com.github.raziu75.lighttrekking.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ClothesItemCard(onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .height(150.dp)
            .width(150.dp),
        elevation = 20.dp,
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.primary,
        onClick = {onClick()}
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Vetements")
            Text(text = "kilos")
        }
    }
}