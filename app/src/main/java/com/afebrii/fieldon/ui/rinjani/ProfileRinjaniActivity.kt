package com.afebrii.fieldon.ui.rinjani

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.afebrii.fieldon.R
import com.afebrii.fieldon.ui.beranda.BerandaActivity
import com.afebrii.fieldon.ui.kategoriLapangan.KategoriLapanganActivity1
import com.afebrii.fieldon.ui.pelatihan.PelatihanActivity
import com.afebrii.fieldon.ui.pemesanan.PesananActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileRinjaniActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile_rinjani)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // INTENT navigation masuk ke dalam fitur lapangan
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_lapangan -> {
                    val intent = Intent(this, KategoriLapanganActivity1::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_pelatihan -> {
                    val intent = Intent(this, PelatihanActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_pemesanan -> {
                    val intent = Intent(this, PesananActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_home -> {
                    val intent = Intent(this, BerandaActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}