package com.afebrii.fieldon.ui.detailLapangan

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.afebrii.fieldon.R
import com.afebrii.fieldon.ui.main.MainActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class DetailBookingActivity : AppCompatActivity() {

    lateinit var tvDate:TextView
    lateinit var btnShowDatePicker: Button
    private val calendar = Calendar.getInstance()

    private lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_booking)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ic back
        val ivBack : ImageView = findViewById(R.id.iv_back_pemesanan)
        ivBack.setOnClickListener{
            val Intent = Intent(this, DetailLapanganActivity::class.java)
            startActivity(Intent)
            finish()
        }

        //        calender
        tvDate = findViewById<TextView>(R.id.tv_show_date)
        btnShowDatePicker = findViewById<Button>(R.id.btn_ubah_data)
        btnShowDatePicker.setOnClickListener {
            showDatePicker()
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            this, { _, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, dayOfMonth)
                val dateFormat = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale("id", "ID"))
                val formattedDate = dateFormat.format(selectedDate.time)

                //menampilkan layout custom date
                showCustomDialogBoxField()

            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    private fun showCustomDialogBoxField() {
        dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.activity_pilih_lapangan)

        val lapangan1 = dialog.findViewById<CardView>(R.id.lapangan1)
        val lapangan2 = dialog.findViewById<CardView>(R.id.lapangan2)
        val lapangan3 = dialog.findViewById<CardView>(R.id.lapangan3)

        val btnPilihLapangan = dialog.findViewById<Button>(R.id.btn_pilih_Lapangan)

        val cardColorloop = listOf(lapangan1, lapangan2, lapangan3)
        fun changeCardViewColor(vararg cardViews: CardView) {
            cardViews.forEach { cardView ->
                val textViewId = arrayOf(R.id.tv_lapangan1, R.id.tv_lapangan2, R.id.tv_lapangan3)
                textViewId.forEach { textViewId ->
                    val textView = cardView.findViewById<TextView>(textViewId)
                    textView?.setTextColor(ContextCompat.getColor(this, android.R.color.black))
                }
                cardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.secondaryYellow
                    )
                )
            }
        }

        fun resetCardViewColors(vararg cardViews: CardView) {
            cardViews.forEach { cardView ->
                val textViewId = arrayOf(R.id.tv_lapangan1, R.id.tv_lapangan2, R.id.tv_lapangan3)
                textViewId.forEach { textViewId ->
                    val textView = cardView.findViewById<TextView>(textViewId)
                    textView?.setTextColor(ContextCompat.getColor(this, android.R.color.black))
                }
                cardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.grey))
            }
        }

        cardColorloop.forEachIndexed { index, timeSlot ->
            timeSlot.setOnClickListener {
                resetCardViewColors(*cardColorloop.toTypedArray())
                changeCardViewColor(timeSlot)
            }
        }

        btnPilihLapangan.setOnClickListener {
            val intent = Intent(this, DetailBookingActivity::class.java)
            startActivity(intent)
            dialog.dismiss()
            overridePendingTransition(R.anim.static_animation, R.anim.zoom_out)
        }

        dialog.show()
    }
}