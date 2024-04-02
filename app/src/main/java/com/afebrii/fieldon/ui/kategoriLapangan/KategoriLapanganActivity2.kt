package com.afebrii.fieldon.ui.kategoriLapangan

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.afebrii.fieldon.R
import com.afebrii.fieldon.ui.detailLapangan.DetailLapanganActivity

class KategoriLapanganActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kategori_lapangan2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // btn kembali to beranda
        val btnFutsalDetail : ImageButton = findViewById(R.id.btn_futsal_detail)
        btnFutsalDetail.setOnClickListener{
            val Intent = Intent(this, DetailLapanganActivity::class.java)
            startActivity(Intent)
            finish()
        }
    }
}