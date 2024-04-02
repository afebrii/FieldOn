package com.afebrii.fieldon.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.afebrii.fieldon.R
import com.afebrii.fieldon.ui.pilihProfile.PilihProfilActivity
import com.afebrii.fieldon.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        intent login to home
        val btnMasuk : Button = findViewById(R.id.btn_masuk)
        val edtUsername: EditText = findViewById(R.id.edt_username)
        val edtPassword: EditText = findViewById(R.id.edt_password)
        btnMasuk.setOnClickListener {
            val inputUsername = edtUsername.text.toString()
            val inputPassword = edtPassword.text.toString()
            if (inputUsername == "Rinjani" && inputPassword == "12345678"){
                val intent = Intent(this, PilihProfilActivity::class.java)
                startActivity(intent)
                finish()
            }else  {
                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
            }
        }

//        intent Daftar user
        val tvDaftar : TextView = findViewById(R.id.tv_daftar)
        tvDaftar.setOnClickListener{
            val Intent = Intent(this, RegisterActivity::class.java)
            startActivity(Intent)
            finish()
        }

    }
}