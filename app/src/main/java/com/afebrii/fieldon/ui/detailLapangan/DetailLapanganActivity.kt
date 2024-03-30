package com.afebrii.fieldon.ui.detailLapangan

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.afebrii.fieldon.R
import com.afebrii.fieldon.ui.main.MainActivity
import com.google.android.material.tabs.TabLayout
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class DetailLapanganActivity : AppCompatActivity() {

    private lateinit var iv1: ImageView
    private lateinit var iv2: ImageView
    private lateinit var iv3: ImageView

    private lateinit var viewPager2: ViewPager2
    private lateinit var vpFasilitasUlasan: ViewPager2
    private lateinit var tabLayout: TabLayout

    private lateinit var adapterFragment: FragmentPageAdaptor

    private lateinit var dialog: Dialog

//    calender
    lateinit var tvDate:TextView
    lateinit var btnShowDatePicker: Button
    private val calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_lapangan)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        ic back
        val ivBack : ImageView = findViewById(R.id.iv_back)
        ivBack.setOnClickListener{
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
            finish()
        }

//        menampilkan gambar image
        viewPager2 = findViewById(R.id.vp_image_lapangan)
        iv1 = findViewById(R.id.iv1)
        iv2 = findViewById(R.id.iv2)
        iv3 = findViewById(R.id.iv3)

        val images = listOf(R.drawable.image_lapangan, R.drawable.image_lapangan, R.drawable.image_lapangan)
        val adapter = ViewPagerAdaptor(images)
        viewPager2.adapter = adapter

        //        tablayout fasilitas dan ulasan lapangan
        tabLayout = findViewById(R.id.tablayout)
        vpFasilitasUlasan = findViewById(R.id.vp_fasilitas_ulasan)
        adapterFragment = FragmentPageAdaptor(supportFragmentManager, lifecycle)
        vpFasilitasUlasan.adapter = adapterFragment

//        gambar lapangan dan dot animation
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageSelected(position)
                changeColor()
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                changeColor()
            }

        })

//        calender
        tvDate = findViewById<TextView>(R.id.tv_show_date)
        btnShowDatePicker = findViewById<Button>(R.id.btn_sewa_sekarang)

        btnShowDatePicker.setOnClickListener {
            showDatePicker()
        }
    }

//  gambar lapangan dan dot animation
    fun changeColor(){
        when(viewPager2.currentItem){
            0 -> {
                iv1.setBackgroundColor(applicationContext.resources.getColor(R.color.secondaryYellow))
                iv2.setBackgroundColor(applicationContext.resources.getColor(R.color.white))
                iv3.setBackgroundColor(applicationContext.resources.getColor(R.color.white))
            }
            1 -> {
                iv1.setBackgroundColor(applicationContext.resources.getColor(R.color.white))
                iv2.setBackgroundColor(applicationContext.resources.getColor(R.color.secondaryYellow))
                iv3.setBackgroundColor(applicationContext.resources.getColor(R.color.white))
            }
            2 -> {
                iv1.setBackgroundColor(applicationContext.resources.getColor(R.color.white))
                iv2.setBackgroundColor(applicationContext.resources.getColor(R.color.white))
                iv3.setBackgroundColor(applicationContext.resources.getColor(R.color.secondaryYellow))
            }
        }

//        tablayout fasilitas dan ulasan lapangan
        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null){
                    vpFasilitasUlasan.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        vpFasilitasUlasan.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })
    }

//    calender
    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            this, { _, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, dayOfMonth)
                val dateFormat = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale("id", "ID"))
                val formattedDate = dateFormat.format(selectedDate.time)

                //menampilkan layout custom date
                showCustomDialogBoxTime()

            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    //menampilkan layout custom date
    private fun showCustomDialogBoxTime() {
        dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.activity_pilih_waktu)

        val time10 = dialog.findViewById<CardView>(R.id.time10)
        val time11 = dialog.findViewById<CardView>(R.id.time11)
        val time12 = dialog.findViewById<CardView>(R.id.time12)
        val time13 = dialog.findViewById<CardView>(R.id.time13)
        val time14 = dialog.findViewById<CardView>(R.id.time14)
        val time15 = dialog.findViewById<CardView>(R.id.time15)
        val time16 = dialog.findViewById<CardView>(R.id.time16)
        val time17 = dialog.findViewById<CardView>(R.id.time17)
        val time18 = dialog.findViewById<CardView>(R.id.time18)
        val time19 = dialog.findViewById<CardView>(R.id.time19)
        val time20 = dialog.findViewById<CardView>(R.id.time20)
        val time21 = dialog.findViewById<CardView>(R.id.time21)
        val btnPilihWaktu = dialog.findViewById<Button>(R.id.btn_pilih_waktu)

        val cardColorloop = listOf(time10, time11, time12, time13, time14, time15, time16, time17, time18, time19, time20, time21)

        fun changeCardViewColor(vararg cardViews: CardView) {
            cardViews.forEach { cardView ->
                val textViewId = arrayOf(R.id.tv_10, R.id.tv_11, R.id.tv_12,R.id.tv_13, R.id.tv_14, R.id.tv_15, R.id.tv_16, R.id.tv_17,R.id.tv_18, R.id.tv_19, R.id.tv_20,R.id.tv_21)
                textViewId.forEach { textViewId ->
                    val textView = cardView.findViewById<TextView>(textViewId)
                    textView?.setTextColor(ContextCompat.getColor(this, android.R.color.black))
                }
                cardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.secondaryYellow))
            }
        }

        fun resetCardViewColors(vararg cardViews: CardView) {
            cardViews.forEach { cardView ->
                val textViewId = arrayOf(R.id.tv_10, R.id.tv_11, R.id.tv_12,R.id.tv_13, R.id.tv_14, R.id.tv_15, R.id.tv_16, R.id.tv_17,R.id.tv_18, R.id.tv_19, R.id.tv_20,R.id.tv_21)
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

        btnPilihWaktu.setOnClickListener {
            dialog.dismiss()
            showCustomDialogBoxField()
        }

        dialog.show()
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
            dialog.dismiss()
            val intent = Intent(this, DetailBookingActivity::class.java)
            startActivity(intent)
            finish()
        }

        dialog.show()
    }
}