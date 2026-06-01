package com.vicoel.appcalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var canAddOperation: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val workingsTV = findViewById<TextView>(R.id.workingsTV)
        val resultsTV = findViewById<TextView>(R.id.resultsTV)






        fun numberAction(view: View){
            if(view is Button){
                workingsTV.append(view.text)
            }
        }
        fun operationAction(view: View){
            if(view is Button){
                workingsTV.append(view.text)
            }
        }
        fun allClearAction(view: View){
            workingsTV.text = ""
            resultsTV.text = ""
        }


        fun backSpaceAction(view: View){
            val length = workingsTV.length()
            if(length > 0)
                workingsTV.text = workingsTV.text.subSequence(0, length - 1)



        }
        fun equalsAction(view: View){

        }

    }
}