package com.github.raziu75.lighttrekking.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.github.raziu75.lighttrekking.model.Screens
import com.github.raziu75.lighttrekking.vm.ItemViewModel

@Composable
fun Home(vm: ItemViewModel = viewModel()) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Screens.valueOf(backStackEntry?.destination?.route?: Screens.STUFF.name)

    Scaffold(
        topBar = { AppBar(
            up = {navController.navigateUp() },
            canGoBack = navController.previousBackStackEntry != null,
            screens = currentScreen
        ) },
        content = { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = Screens.STUFF.name,
                modifier = Modifier.padding(paddingValues)
            )
            {
                composable(Screens.STUFF.name){
                    BodyStuff(modifier = Modifier, navController = navController)
                }
                composable(Screens.HOMESTUFF.name){
                    MainStuffView(navController = navController, vm = vm)
                }
                composable(Screens.CLOTHE.name){
                    ClothesItemDetails(vm = vm, navController = navController)
                }
                composable(Screens.FOOD.name){
                    FoodDetails(vm = vm, navController = navController)
                }
                composable(Screens.ACCESSORY.name){
                    AccessoriesDetails(vm = vm, navController = navController)
                }
                composable(Screens.OTHER.name){
                    OtherDetails(vm = vm, navController = navController)
                }
                composable(Screens.LISTITEMS.name){
                    ListItemView(vm = vm, navController = navController)
                }
            }
        }
    )
}