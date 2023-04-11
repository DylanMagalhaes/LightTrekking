package com.github.raziu75.lighttrekking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.raziu75.lighttrekking.ui.composables.*
import com.github.raziu75.lighttrekking.ui.theme.LightTrekkingTheme
import com.github.raziu75.lighttrekking.ui.uiState.ItemState
import com.github.raziu75.lighttrekking.vm.ItemViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LightTrekkingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "home"
                    )
                    {
                        composable("home"){
                            BodyStuff(modifier = Modifier, navController = navController)
                        }
                        composable("mainStuff"){
                            MainStuffView(navController = navController)
                        }
                        composable("clothesDetails"){
                            ClothesItemDetails(vm = ItemViewModel(), navController = navController)
                        }
                        composable("foodDetails"){
                            FoodDetails(vm = ItemViewModel(), navController = navController)
                        }
                        composable("accessoriesDetails"){
                            AccessoriesDetails(vm = ItemViewModel(), navController = navController)
                        }
                        composable("otherDetails"){
                            OtherDetails(vm = ItemViewModel(), navController = navController)
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LightTrekkingTheme {

    }
}