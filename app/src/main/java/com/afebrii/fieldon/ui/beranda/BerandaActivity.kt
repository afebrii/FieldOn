package com.afebrii.fieldon.ui.beranda
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.afebrii.fieldon.R
import com.afebrii.fieldon.ui.kategoriLapangan.KategoriLapanganActivity1
import com.afebrii.fieldon.ui.pelatihan.PelatihanActivity
import com.afebrii.fieldon.ui.pemesanan.PesananActivity
import com.afebrii.fieldon.ui.rinjani.ProfileRinjaniActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class BerandaActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

        // Mendapatkan referensi ke LinearLayout di dalam HorizontalScrollView
        val linearLayout: LinearLayout = findViewById(R.id.linear_layout)

        // Membuat dan menambahkan beberapa kartu secara dinamis
        for (i in 0 until 5) {
            // Membuat objek CardView
            val cardView = CardView(this)
            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(16, 16, 16, 16) // Atur margin sesuai kebutuhan
            cardView.layoutParams = layoutParams

            // Menginflasi layout kartu dari file XML
            val cardLayout = LayoutInflater.from(this).inflate(R.layout.card_layout, null)
            cardView.addView(cardLayout)

            // Menambahkan kartu ke dalam LinearLayout
            linearLayout.addView(cardView)
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





