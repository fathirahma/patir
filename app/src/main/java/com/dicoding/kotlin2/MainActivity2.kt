package com.dicoding.kotlin2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nama = findViewById<EditText>(R.id.edittxtEmail)
        val pass = findViewById<EditText>(R.id.edittxtPassword)

        val buttonClick = findViewById<Button>(R.id.btnSubmit)

        buttonClick.setOnClickListener {
            if (nama.text.toString()=="tayaa" && pass.text.toString()=="123") {
                val intent = Intent(this,menu::class.java)
                Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show()

                startActivity(intent)
            } else {
                Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
            }

            }
    }
}