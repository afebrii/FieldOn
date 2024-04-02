package com.afebrii.fieldon.ui.pelatihan

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
import com.afebrii.fieldon.ui.detailLapangan.DetailLapanganActivity
import com.afebrii.fieldon.ui.kategoriLapangan.KategoriLapanganActivity1
import com.afebrii.fieldon.ui.pemesanan.PesananActivity
import com.afebrii.fieldon.ui.rinjani.ProfileRinjaniActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class PelatihanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pelatihan)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ic back
        val ivBack : ImageView = findViewById(R.id.iv_back_pelatihan)
        ivBack.setOnClickListener{
            val Intent = Intent(this, BerandaActivity::class.java)
            startActivity(Intent)
            finish()
        }

//        val btnDaftarPelatihan : Button = findViewById(R.id.btn_daftar_pelatihan)
//        btnDaftarPelatihan.setOnClickListener{
//            val Intent = Intent(this, BerandaActivity::class.java)
//            startActivity(Intent)
//            finish()
//        }

        // INTENT navigation masuk ke dalam fitur lapangan
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_lapangan -> {
                    val intent = Intent(this, KategoriLapanganActivity1::class.java)
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