package com.afebrii.fieldon.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.DatePickerDialog
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.afebrii.fieldon.R
import com.afebrii.fieldon.ui.detailLapangan.DetailBookingActivity
import com.afebrii.fieldon.ui.detailLapangan.DetailLapanganActivity
import com.afebrii.fieldon.ui.login.LoginActivity
import com.afebrii.fieldon.ui.main.MainActivity
import com.afebrii.fieldon.ui.payment.ConfirmPaymentActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Handler().postDelayed({
            startActivity(Intent(this,DetailLapanganActivity::class.java))
            finish()
            overridePendingTransition(R.anim.static_animation, R.anim.zoom_out)
        }, 3000L)
    }
}