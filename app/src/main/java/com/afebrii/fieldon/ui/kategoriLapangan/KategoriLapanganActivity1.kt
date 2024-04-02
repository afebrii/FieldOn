package com.afebrii.fieldon.ui.kategoriLapangan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.afebrii.fieldon.R
import com.afebrii.fieldon.ui.beranda.BerandaActivity
import com.afebrii.fieldon.ui.pemesanan.PesananActivity
import com.afebrii.fieldon.ui.rinjani.ProfileRinjaniActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class KategoriLapanganActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kategori_lapangan1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // btn kembali to beranda
        val btnFutsal : ImageButton = findViewById(R.id.btn_futsal)
        btnFutsal.setOnClickListener{
            val Intent = Intent(this, KategoriLapanganActivity2::class.java)
            startActivity(Intent)
            finish()
        }

        // INTENT navigation masuk ke dalam fitur lapangan
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val intent = Intent(this, BerandaActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_pelatihan -> {
                    val intent = Intent(this, KategoriLapanganActivity1::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_pemesanan -> {
                    val intent = Intent(this, PesananActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_profile -> {
                    val intent = Intent(this, ProfileRinjaniActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

    }
}