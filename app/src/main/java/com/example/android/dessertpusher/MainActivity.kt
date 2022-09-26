/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.dessertpusher

import android.content.ActivityNotFoundException
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.res.TypedArrayUtils.getString
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android.dessertpusher.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), LifecycleObserver {


    // Contains all the views
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: GameViewModel

    /** Dessert Data **/

    /**
     * Simple data class that represents a dessert. Includes the resource id integer associated with
     * the image, the price it's sold for, and the startProductionAmount, which determines when
     * the dessert starts to be produced.
     */
    data class Dessert(val imageId: Int, val price: Int, val startProductionAmount: Int)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Use Data Binding to get reference to the views
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.gameViewModel = viewModel

        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)


        binding.dessertButton.setOnClickListener {
            viewModel.onDessertClicked()

        viewModel.revenue.observe(this, Observer {
            binding.revenue = it
        } )

            viewModel.dessertsSold.observe(this, Observer {
                binding.amountSold = it
            })

            viewModel.showCurrentDessert()
        // Make sure the correct dessert is showing
        binding.dessertButton.setImageResource(viewModel.currentDessert.imageId)
    }

    /**
     * Updates the score when the dessert is clicked. Possibly shows a new dessert.
     */


    /**
     * Determine which dessert to show.
     */

    }

    /**
     * Menu methods
     */
    /*fun onShare() {
        val shareIntent = ShareCompat.IntentBuilder.from(this)
            .setText.getString(R.string.share_text, dessertsSold, revenue)
            .setType("text/plain")
            .intent
        try {
            startActivity(shareIntent)
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(this, getString(R.string.sharing_not_available),
                Toast.LENGTH_LONG).show()
        }
    }

fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.main_menu, menu)
    return super.onCreateOptionsMenu(menu)
}

fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
        R.id.shareMenuButton -> onShare()
    }
    return super.onOptionsItemSelected(item)*/
}


