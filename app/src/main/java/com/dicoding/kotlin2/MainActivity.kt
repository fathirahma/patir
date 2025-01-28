package com.dicoding.kotlin2

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Inisialisasi tombol kembali
        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        btnBack.setOnClickListener {
            goToMenu()
        }

        val btnExit: Button = findViewById(R.id.btnExit)

        btnExit.setOnClickListener {
            // Menutup aplikasi
            finishAffinity()
        }

        btnExit.setOnClickListener {
            // Tampilkan dialog konfirmasi
            AlertDialog.Builder(this)
                .setTitle("Konfirmasi Keluar")
                .setMessage("Apakah Anda yakin ingin keluar dari aplikasi?")
                .setPositiveButton("Ya") { _, _ ->
                    finishAffinity() // Tutup aplikasi
                }
                .setNegativeButton("Tidak", null)
                .show()
        }

        val textView3: TextView = findViewById(R.id.textView3)

        textView3.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Tentang Saya !")
                .setMessage("Saya adalah orang sederhana yang mencintai teman sekelas saya.")
                .setPositiveButton("OK", null)
                .show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun goToMenu() {
        val intent = Intent(this, menu::class.java) // Ganti dengan halaman menu utama
        startActivity(intent)
        finish()
    }
}