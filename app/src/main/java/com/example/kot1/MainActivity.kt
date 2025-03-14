package com.example.kot1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val mensaje = "Hola, kotlin"
    val nombre = "Irvin"
    var msgPersonalizado = "Presiona el boton"
    var bandera = false //Esta es una bandera
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val tvMensaje = findViewById<TextView>(R.id.texto1)
        val btnCambiar = findViewById<Button>(R.id.btnCambiar)
        val btnCiclo = findViewById<Button>(R.id.btnCiclo)
        tvMensaje.setText(msgPersonalizado)
        btnCambiar.setOnClickListener{

            if(bandera){
                msgPersonalizado = "Este mensaje cambia"

            }else{
                msgPersonalizado = "Y puede regresar a como estaba"
            }
            bandera= !bandera
            tvMensaje.setText(msgPersonalizado)
        }

        btnCiclo.setOnClickListener {
            msgPersonalizado = hacerCiclo(9)
            tvMensaje.setText(msgPersonalizado)
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun hacerCiclo(max: Int):String {
        var resultado = ""
        for (i in 1..max){
            resultado += "$i, "
        }
        return resultado
    }
}