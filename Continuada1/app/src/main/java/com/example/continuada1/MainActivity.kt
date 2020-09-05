package com.example.continuada1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun validar(componete: View) {

        if (!et_nome.text.toString().equals("") && !et_n1.text.toString().equals("")
            && !et_n2.text.toString().equals("")
        ) {
            val nome = et_nome.text.toString()
            val n1 = et_n1.text.toString().toDouble()
            val n2 = et_n2.text.toString().toDouble()

            if (!nome.all { it.isLetter() || !nome.equals(" ") }) {
                Toast.makeText(
                    this,
                    "Por favor preencha seu nome corretamente apenas com letras",
                    Toast.LENGTH_LONG
                ).show()
            } else if (n1 < 0.0 || n1 > 10.0 || n1 == null) {
                Toast.makeText(
                    this, "Por favor coloque uma nota entre 0 e 10", Toast.LENGTH_LONG
                ).show()
            } else if (n2 < 0.0 || n2 > 10.0 || n2 == null) {
                Toast.makeText(this, "Por favor coloque uma nota entre 0 e 10", Toast.LENGTH_LONG)
                    .show()
            } else {
                val media = (n1 + n2) / 2.0

                if (media < 5) {
                    tvresultado.text =
                        "$nome sua média é $media e infelizmente você foi reprovado. Estude mais!"
                    tvresultado.setTextColor(Color.RED)
                    tvresultado.visibility = View.VISIBLE
                } else if (media <= 7) {
                    tvresultado.text =
                        "$nome sua média é $media e você foi aprovado. Porém você ainda tem muito potencial para melhorar, então estude mais!"
                    tvresultado.setTextColor(Color.DKGRAY)
                    tvresultado.visibility = View.VISIBLE
                } else {
                    tvresultado.text =
                        "$nome sua média é $media e você foi aprovado. Sua nota está ótima, continue sendo um aluno exemplar!"
                    tvresultado.setTextColor(Color.GREEN)
                    tvresultado.visibility = View.VISIBLE
                }
            }
        }
        else {
            Toast.makeText(this, "Por favor preencha todos os campos", Toast.LENGTH_SHORT).show()
        }
    }
}

