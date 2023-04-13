package com.github.raziu75.lighttrekking.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.github.raziu75.lighttrekking.model.Screens
import com.github.raziu75.lighttrekking.vm.ItemViewModel

@Composable
fun MainStuffView(navController: NavController, vm: ItemViewModel) {
    val itemState = vm.uiState.collectAsState()

    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ClothesItemCard({ navController.navigate(Screens.CLOTHE.name) }, vm = vm)
            AccessoriesItemCard({ navController.navigate(Screens.ACCESSORY.name) }, vm = vm)
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Poids total: ${itemState.value.totalWeight} kg",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            FoodItemCard({ navController.navigate(Screens.FOOD.name) }, vm = vm)
            OtherItemCard({ navController.navigate(Screens.OTHER.name) }, vm = vm)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Afficher la Liste complete")
            }
        }
    }
}
