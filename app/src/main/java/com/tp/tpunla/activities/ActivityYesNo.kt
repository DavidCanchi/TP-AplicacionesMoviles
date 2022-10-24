package com.tp.tpunla.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.tp.tpunla.R

class ActivityYesNo : AppCompatActivity() {

    lateinit var textYesNo: TextView
    lateinit var imageTextNo: ImageView
    lateinit var buttonAceptar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yes_no)
        textYesNo = findViewById(R.id.yesno_text)
        imageTextNo = findViewById(R.id.yesno_image)
        buttonAceptar = findViewById(R.id.buttonAceptar)

        buttonAceptar.setOnClickListener {
            val activityFilms = Intent(this, ActivityFilms::class.java)
            startActivity(activityFilms)
            finish()
        }

    }
}