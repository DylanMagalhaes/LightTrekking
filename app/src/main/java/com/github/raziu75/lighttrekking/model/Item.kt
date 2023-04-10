package com.github.raziu75.lighttrekking.model

data class Item(
    val itemName: String,
    val description: String,
    val weight: Double,
    val quantity: Int,
    val categoryName: String,
    val unitWeight: List<String> = listOf("kg", "g")
){
    fun weightAddition(weight: Double): Double{
        var totalWeight = 0.0
        totalWeight += weight
        return totalWeight
    }
}
