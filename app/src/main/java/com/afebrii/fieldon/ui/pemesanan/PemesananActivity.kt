package com.afebrii.fieldon.ui.pemesanan

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.afebrii.fieldon.R

class PemesananActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pemesanan)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
    class PemesananActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_pemesanan)

            val buttonWithUnderline1 = findViewById<Button>(R.id.buttonWithUnderline)
            val buttonWithUnderline2 = findViewById<Button>(R.id.buttonWithUnderline2)
            buttonWithUnderline1.setOnClickListener {
                val underlineView = findViewById<View>(R.id.underline1)
                underlineView.setBackgroundColor(ContextCompat.getColor(this, R.color.primaryBlue))
            }
            buttonWithUnderline2.setOnClickListener {
                val underlineView = findViewById<View>(R.id.underline2)
                underlineView.setBackgroundColor(ContextCompat.getColor(this, R.color.primaryBlue))
            }
        }
    }


}