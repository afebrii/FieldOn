package com.afebrii.fieldon.ui.pemesanan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.afebrii.fieldon.R
import com.afebrii.fieldon.ui.beranda.BerandaActivity
import com.afebrii.fieldon.ui.kategoriLapangan.KategoriLapanganActivity1
import com.afebrii.fieldon.ui.live_chat.Live_ChatActivity
import com.afebrii.fieldon.ui.pelatihan.PelatihanActivity
import com.afebrii.fieldon.ui.rinjani.ProfileRinjaniActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class PesananActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pesanan)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnImageView15 : ImageView = findViewById(R.id.imageView15)
        btnImageView15.setOnClickListener{
            val Intent = Intent(this, Live_ChatActivity::class.java)
            startActivity(Intent)
            finish()
        }

        val btnBack : ImageView = findViewById(R.id.imageView9)
        btnBack.setOnClickListener{
            val Intent = Intent(this, BerandaActivity::class.java)
            startActivity(Intent)
            finish()
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
                R.id.navigation_home -> {
                    val intent = Intent(this, BerandaActivity::class.java)
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