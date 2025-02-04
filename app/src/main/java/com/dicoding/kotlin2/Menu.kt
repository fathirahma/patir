package com.dicoding.kotlin2

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Tombol Profil
        val btnProfil: Button = findViewById(R.id.btnprofil)
        btnProfil.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Tombol Kalkulator
        val btnKalkulator: Button = findViewById(R.id.btnkalkulator)
        btnKalkulator.setOnClickListener {
            val intent = Intent(this, kalkulator::class.java)
            startActivity(intent)
        }

        val btnLogout: Button = findViewById(R.id.btnlogout)
        btnLogout.setOnClickListener {
            showLogoutDialog()
        }
    }

    // Fungsi untuk menampilkan dialog konfirmasi logout
    private fun showLogoutDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Logout")
        builder.setMessage("Apakah Anda yakin ingin logout?")
        builder.setPositiveButton("Ya") { dialogInterface: DialogInterface, i: Int ->
            val intent = Intent(this, MainActivity2::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
        builder.setNegativeButton("Tidak") { dialogInterface: DialogInterface, i: Int ->
            // Tidak melakukan apa-apa
        }
        builder.show()
    }
}