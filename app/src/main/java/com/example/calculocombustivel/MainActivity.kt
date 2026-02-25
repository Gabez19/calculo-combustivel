package com.example.calculocombustivel

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Conectando XML com Kotlin
        val editTextAlcool = findViewById<EditText>(R.id.editTextAlcool)
        val editTextGasolina = findViewById<EditText>(R.id.editTextGasolina)
        val buttonCalcular = findViewById<Button>(R.id.buttonCalcular)
        val textViewResultado = findViewById<TextView>(R.id.textViewResultado)

        // Clique do botão
        buttonCalcular.setOnClickListener {

            val alcoolTexto = editTextAlcool.text.toString()
            val gasolinaTexto = editTextGasolina.text.toString()

            if (alcoolTexto.isEmpty() || gasolinaTexto.isEmpty()) {
                textViewResultado.text = "Preencha todos os campos"
                return@setOnClickListener
            }

            val alcool = alcoolTexto.toDouble()
            val gasolina = gasolinaTexto.toDouble()

            if (alcool <= 0 || gasolina <= 0) {
                textViewResultado.text = "Preços devem ser maiores que zero"
                return@setOnClickListener
            }

            val indice = alcool / gasolina

            if (indice < 0.70) {
                textViewResultado.text = "ETANOL é mais vantajoso"
            } else {
                textViewResultado.text = "GASOLINA é mais vantajosa"
            }
        }
    }
}