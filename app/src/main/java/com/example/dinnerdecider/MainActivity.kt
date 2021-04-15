package com.example.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    private val foodList = arrayListOf("Cheffs Xinlai", "PizzaHut", "Domioz", "McDonalds", "Pai Tiffins")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decideButton.setOnClickListener {
            decideButtonClickHandler()
        }

        addFoodButton.setOnClickListener {
            addFoodButtonHandler()
        }

    }

    /**
     * Add Food button handler
     * Function that describes the handling of add food event
     */
    private fun addFoodButtonHandler() {
        val newFood = addFoodTextView.text.toString().trim()
        if (addFoodTextView.text.toString() != "" && addFoodTextView.text != null) {
            foodList.add(newFood)
            Toast.makeText(applicationContext, "Food Added: $newFood", Toast.LENGTH_LONG).show()
        }
        addFoodTextView.text.clear()
    }

    /**
     * Decide button handler
     * Function that handles decide button click event
     */
    private fun decideButtonClickHandler() {
        Log.w("$$$", "Clicked Decide..")
        val random: Random = Random()
        val randomFood = random.nextInt(foodList.count())

        selectedFoodTextView.text = foodList[randomFood]
    }
}