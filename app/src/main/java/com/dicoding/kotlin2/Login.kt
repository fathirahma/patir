package com.dicoding.kotlin2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    private lateinit var dbHelper: Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        dbHelper = Database(this)

        // Find views dari layout
        val usernameEditText = findViewById<EditText>(R.id.edittxtUsername)
        val passwordEditText = findViewById<EditText>(R.id.edittxtPassword)
        val loginButton = findViewById<Button>(R.id.btnSubmit)

        loginButton.setOnClickListener {
            val username = usernameEditText.text?.toString()?.trim() ?: ""
            val password = passwordEditText.text?.toString()?.trim() ?: ""

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (dbHelper.readUser(username, password)) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, Menu::class.java))
                finish()
            } else {
                Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}