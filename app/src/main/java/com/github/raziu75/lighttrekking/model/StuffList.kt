package com.github.raziu75.lighttrekking.model

class StuffList() {

    var listOfStuff: MutableList<Stuff> = mutableListOf()

    fun addStuffToList(stuff: Stuff){
        val newStuff = Stuff("Nouveau stuff")
        listOfStuff.add(newStuff)
    }

    fun removeStuffToList(stuff: Stuff){
        listOfStuff.remove(stuff)
    }

}