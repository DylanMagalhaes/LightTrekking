package com.github.raziu75.lighttrekking.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainStuffView(navController: NavController) {

    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Button(onClick = { navController.popBackStack() }) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ClothesItemCard { navController.navigate("clothesDetails") }
            AccessoriesItemCard { navController.navigate("accessoriesDetails") }
        }
        Spacer(modifier = Modifier.height(70.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            FoodItemCard { navController.navigate("foodDetails") }
            OtherItemCard { navController.navigate("otherDetails") }
        }
    }
}