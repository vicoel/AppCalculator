package com.vicoel.appcalculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.vicoel.appcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Habilitar edge-to-edge
        enableEdgeToEdge()

        // Inflar o binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar insets para o layout principal
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupClickListeners()
    }

    @SuppressLint("SetTextI18n")
    private fun setupClickListeners() {
        with(binding) {

            btn0.setOnClickListener { workingsTV.append("0") }
            btn1.setOnClickListener { workingsTV.append("1") }
            btn2.setOnClickListener { workingsTV.append("2") }
            btn3.setOnClickListener { workingsTV.append("3") }
            btn4.setOnClickListener { workingsTV.append("4") }
            btn5.setOnClickListener { workingsTV.append("5") }
            btn6.setOnClickListener { workingsTV.append("6") }
            btn7.setOnClickListener { workingsTV.append("7") }
            btn8.setOnClickListener { workingsTV.append("8") }
            btn9.setOnClickListener { workingsTV.append("9") }

            btnPls.setOnClickListener { workingsTV.append(" + ") }
            btnMns.setOnClickListener { workingsTV.append(" - ") }
            btnMtp.setOnClickListener { workingsTV.append(" * ") }
            btnDvd.setOnClickListener { workingsTV.append(" / ") }

            btnAc.setOnClickListener {
                workingsTV.text = ""
                resultsTV.text = ""
            }

            btnBSpace.setOnClickListener {
                val text = workingsTV.text.toString()
                if (text.isNotEmpty()) {
                    workingsTV.text = text.dropLast(1)
                }
            }

            btnEqls.setOnClickListener {
                try {
                    val expression = workingsTV.text.toString()
                    val result = evaluateExpression(expression)
                    resultsTV.text = result.toString()
                } catch (e: Exception) {
                    resultsTV.text = "Erro"
                }
            }
        }
    }


    private fun evaluateExpression(expression: String): Double {
        val parts = expression.split(" ")
        if (parts.size == 3) {
            val a = parts[0].toDouble()
            val op = parts[1]
            val b = parts[2].toDouble()
            return when (op) {
                "+" -> a + b
                "-" -> a - b
                "*" -> a * b
                "/" -> a / b
                else -> 0.0
            }
        }
        return 0.0
    }
}



