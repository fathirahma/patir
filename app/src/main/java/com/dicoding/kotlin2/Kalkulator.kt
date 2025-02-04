package com.dicoding.kotlin2

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class kalkulator : AppCompatActivity() {
    private lateinit var display: TextView
    private lateinit var operatorNotif: TextView
    private var isinum: Double = 0.0
    private var jumlah: Double = 0.0
    private var operator: String = ""
    private var isNewOp = true
    private lateinit var mp: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator)

        display = findViewById(R.id.display)
        operatorNotif = findViewById(R.id.operatorNotif)

        // Inisialisasi tombol kembali
        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        btnBack.setOnClickListener {
            goToMenu()
        }

        setNumberListeners()
        setOperatorListeners()
    }

    private fun goToMenu() {
        val intent = Intent(this, menu::class.java) // Ganti dengan halaman menu utama
        startActivity(intent)
        finish()
    }

    private fun setNumberListeners() {
        val buttons = listOf(R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9)
        for (button in buttons) {
            findViewById<Button>(button).setOnClickListener {
                playSound(button)
                appendNumber((it as Button).text.toString())
            }
        }
    }

    private fun appendNumber(num: String) {
        if (isNewOp) {
            display.text = num
            isNewOp = false
        } else {
            if (display.text.toString() == "0") {
                display.text = num
            } else {
                display.append(num)
            }
        }
    }

    private fun setOperatorListeners() {
        val operators = mapOf(
            R.id.btnPlus to "+",
            R.id.btnMinus to "-",
            R.id.btnMultiply to "*",
            R.id.btnDivide to "/"
        )

        for ((button, op) in operators) {
            findViewById<Button>(button).setOnClickListener {
                playSound(button)
                isinum = display.text.toString().toDouble()
                operator = op
                operatorNotif.text = operator
                isNewOp = true
            }
        }

        findViewById<Button>(R.id.btnEqual).setOnClickListener {
            playSound(R.id.btnEqual)
            val secondNum = display.text.toString().toDouble()
            jumlah = when (operator) {
                "+" -> isinum + secondNum
                "-" -> isinum - secondNum
                "*" -> isinum * secondNum
                "/" -> if (secondNum != 0.0) isinum / secondNum else 0.0
                else -> 0.0
            }
            display.text = jumlah.toString()
            operatorNotif.text = ""
            isNewOp = true
        }
    }

    private fun playSound(buttonId: Int) {
        val soundRes = when (buttonId) {
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3 -> R.raw.fart
            R.id.btn4, R.id.btn5, R.id.btn6 -> R.raw.fart
            else -> R.raw.fart
        }
        mp = MediaPlayer.create(this, soundRes)
        mp.start()
    }
}
