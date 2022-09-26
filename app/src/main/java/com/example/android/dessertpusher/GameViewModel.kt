package com.example.android.dessertpusher

import android.content.ActivityNotFoundException
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class GameViewModel: ViewModel(){

    private var _revenue = MutableLiveData<Int>()
        val revenue : LiveData<Int>
            get() = _revenue

    var _dessertsSold = MutableLiveData<Int>()
        val dessertsSold : LiveData<Int>
        get() = _dessertsSold


    init {
        _revenue.value = 0
        _dessertsSold.value = 0


    }
    val allDesserts = listOf(
        MainActivity.Dessert(R.drawable.cupcake, 5, 0),
        MainActivity.Dessert(R.drawable.donut, 10, 5),
        MainActivity.Dessert(R.drawable.eclair, 15, 20),
        MainActivity.Dessert(R.drawable.froyo, 30, 50),
        MainActivity.Dessert(R.drawable.gingerbread, 50, 100),
        MainActivity.Dessert(R.drawable.honeycomb, 100, 200),
        MainActivity.Dessert(R.drawable.icecreamsandwich, 500, 500),
        MainActivity.Dessert(R.drawable.jellybean, 1000, 1000),
        MainActivity.Dessert(R.drawable.kitkat, 2000, 2000),
        MainActivity.Dessert(R.drawable.lollipop, 3000, 4000),
        MainActivity.Dessert(R.drawable.marshmallow, 4000, 8000),
        MainActivity.Dessert(R.drawable.nougat, 5000, 16000),
        MainActivity.Dessert(R.drawable.oreo, 6000, 20000)
    )
     var currentDessert = allDesserts[0]


     fun onDessertClicked() {

        // Update the score
        _revenue.value = _revenue.value?.plus(currentDessert.price)
        _dessertsSold.value = _dessertsSold.value?.plus(1)

         /*revenue = revenue
         amountSold = dessertsSold*/

        // Show the next dessert
        showCurrentDessert()
    }


        fun showCurrentDessert() {
        var newDessert = allDesserts[0]
        for (dessert in allDesserts) {
            if (dessertsSold.value!! >= dessert.startProductionAmount) {
                newDessert = dessert
            }
            // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
            // you'll start producing more expensive desserts as determined by startProductionAmount
            // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
            // than the amount sold.
            else break
        }

        // If the new dessert is actually different than the current dessert, update the image
        if (newDessert != currentDessert) {
            currentDessert = newDessert
        }


            }
    }

