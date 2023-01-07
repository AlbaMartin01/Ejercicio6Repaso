package com.example.ejercicio6repaso

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var editText: EditText
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        editText = findViewById(R.id.editText)
        imageView = findViewById(R.id.image)

        button.setOnClickListener {
            if (editText.visibility == View.GONE) {
                editText.visibility = View.VISIBLE
                button.text = "Finalizar"
            } else {
                editText.visibility = View.GONE
                button.text = "Comenzar"
            }
        }

        editText.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                editText.hint = ""
            } else {
                if (editText.text.isEmpty()) {
                    editText.hint = "Introduce tu nombre"
                }
            }
        }

            editText.setOnFocusChangeListener {view, hasFocus ->
                if (!hasFocus && editText.text.toString().isEmpty()) {
                    editText.setText("Introduce tu nombre")
                }
            }

        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            @SuppressLint("ResourceAsColor")
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString().contains("Alba", ignoreCase = true)) {
                    imageView.visibility = View.VISIBLE
                } else {
                    imageView.visibility = View.GONE
                }

                if (s.toString().contains("Hola", ignoreCase = true)) {
                    val color = ContextCompat.getColor(applicationContext, R.color.colorX)
                    editText.setTextColor(R.color.white)
                    button.setTextColor(color)
                    window.decorView.setBackgroundColor(color)
                } else {
                    val color = ContextCompat.getColor(applicationContext, android.R.color.black)
                    editText.setTextColor(R.color.white)
                    button.setTextColor(color)
                    window.decorView.setBackgroundColor(color)
                }
            }
        })
    }
}