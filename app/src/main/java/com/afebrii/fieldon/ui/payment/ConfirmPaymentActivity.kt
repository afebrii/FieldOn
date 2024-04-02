package com.afebrii.fieldon.ui.payment

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

class ConfirmPaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirm_payment)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //        ic back
        val ivBack : ImageView = findViewById(R.id.iv_back_pemesanan)
        ivBack.setOnClickListener{
            val Intent = Intent(this, BerandaActivity::class.java)
            startActivity(Intent)
            finish()
        }

        // btn bayar sekarang to paymentactivity
        val btnConfirmPayment : Button = findViewById(R.id.btn_confirm_payment)
        btnConfirmPayment.setOnClickListener{
            val Intent = Intent(this, PaymentActivity::class.java)
            startActivity(Intent)
            finish()
        }
    }
}