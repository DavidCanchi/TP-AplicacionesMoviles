package com.tp.tpunla.activities

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.tp.tpunla.R
import com.tp.tpunla.services.yesno.YesNoClient

class ActivityYesNo : AppCompatActivity() {

    lateinit var textYesNo: TextView
    lateinit var imageTextNo: ImageView
    lateinit var buttonAceptar: Button
    lateinit var progressCircular: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yes_no)
        textYesNo = findViewById(R.id.yesno_text)
        imageTextNo = findViewById(R.id.yesno_image)
        buttonAceptar = findViewById(R.id.buttonAceptar)
        progressCircular = findViewById(R.id.progress_circular)
        val seRecuerdaUsuario = intent.getBooleanExtra("seRecuerdaUsuario", false)

        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        object : Thread() {
            override fun run() {
                runOnUiThread(Runnable {
                    Log.i(ActivityFilmDetail::class.java.name, "Trayendo datos")
                    val response = YesNoClient.api.getAnswer(if(seRecuerdaUsuario) "yes" else "no").execute()
                    val answer = response.body()
                    if (answer != null) {
                        Picasso.get().load(answer.image).into(imageTextNo)
                        textYesNo.setText(if(seRecuerdaUsuario) "Se recordadará el usuario" else "No se recordará el usuario")
                        progressCircular.setVisibility(View.GONE)
                        textYesNo.setVisibility(View.VISIBLE)
                        imageTextNo.setVisibility(View.VISIBLE)
                        buttonAceptar.setVisibility(View.VISIBLE)
                    }
                })
            }
        }.start()

        buttonAceptar.setOnClickListener {
            val activityFilms = Intent(this, ActivityFilms::class.java)
            startActivity(activityFilms)
            finish()
        }

    }
}