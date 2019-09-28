package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> =
            listOf(box_one_text,box_two_text,box_three_text,
                box_four_text,box_five_text,constraint_layout,
                red_button,yellow_button,green_button)

        for (item in clickableViews){
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        when(view.id){

            //Using Color Classes
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            //Using Color Resources
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            //For the buttons
            R.id.red_button -> box_three_text.setBackgroundResource(R.color.myRed)
            R.id.yellow_button -> box_four_text.setBackgroundResource(R.color.myYellow)
            R.id.green_button -> box_five_text.setBackgroundResource(R.color.myGreen)


            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}
