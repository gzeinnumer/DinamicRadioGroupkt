package com.gzeinnumer.dinamicradiogroupkt

import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRadioButton()
    }

    private fun initRadioButton() {
        //get string array from source
        val websitesArray = resources.getStringArray(R.array.websites_array)

        //create radio buttons
        for (i in websitesArray.indices) {
            val radioButton = RadioButton(this)
            radioButton.text = websitesArray[i]
            radioButton.id = i
            rg.addView(radioButton)
        }

        //set listener to radio button group
        rg.setOnCheckedChangeListener { group, checkedId ->
            val checkedRadioButtonId = rg.checkedRadioButtonId
            val radioBtn = findViewById<RadioButton>(checkedRadioButtonId)
            Toast.makeText(applicationContext, radioBtn.text.toString() + "_" + radioBtn.id, Toast.LENGTH_SHORT).show()
        }
    }
}