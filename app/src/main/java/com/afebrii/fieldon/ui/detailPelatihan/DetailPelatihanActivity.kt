package com.afebrii.fieldon.ui.detailPelatihan

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.afebrii.fieldon.R
import com.afebrii.fieldon.ui.beranda.BerandaActivity
import com.afebrii.fieldon.ui.detailLapangan.DetailBookingActivity
import com.afebrii.fieldon.ui.detailLapangan.FragmentPageAdaptor
import com.afebrii.fieldon.ui.detailLapangan.ViewPagerAdaptor
import com.afebrii.fieldon.ui.payment.ConfirmPaymentActivity
import com.google.android.material.tabs.TabLayout

class DetailPelatihanActivity : AppCompatActivity() {

    private lateinit var iv1: ImageView
    private lateinit var iv2: ImageView
    private lateinit var iv3: ImageView

    private lateinit var viewPager2: ViewPager2
    private lateinit var vpFasilitasUlasan: ViewPager2
    private lateinit var tabLayout: TabLayout

    private lateinit var adapterFragment: FragmentPageAdaptor

    private lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_pelatihan)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //        ic back
        val ivBack : ImageView = findViewById(R.id.iv_back)
        ivBack.setOnClickListener{
            val Intent = Intent(this, BerandaActivity::class.java)
            startActivity(Intent)
            finish()
        }

        // btn daftar pelatihan to activity pilih jadwal pelatihan
        val btnDaftarPelatihan : Button = findViewById(R.id.btn_daftar_pelatihan)
        btnDaftarPelatihan.setOnClickListener {
            showCustomDialogBoxTraining()
        }

        //  menampilkan gambar image
        viewPager2 = findViewById(R.id.vp_image_lapangan)
        iv1 = findViewById(R.id.iv1)
        iv2 = findViewById(R.id.iv2)
        iv3 = findViewById(R.id.iv3)

        val images = listOf(R.drawable.image_detail_pelatihan, R.drawable.image_detail_pelatihan, R.drawable.image_detail_pelatihan)
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

    private fun showCustomDialogBoxTraining() {
        dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.activity_pilih_jadwal_pelatihan)

        val lapangan1 = dialog.findViewById<CardView>(R.id.lapangan1)
        val lapangan2 = dialog.findViewById<CardView>(R.id.lapangan2)
        val lapangan3 = dialog.findViewById<CardView>(R.id.lapangan3)

        val btnPesanPelatihan = dialog.findViewById<Button>(R.id.btn_pesan_pelatihan)

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

        btnPesanPelatihan.setOnClickListener {
            dialog.dismiss()
            showCustomDialogBoxSukses()
        }
        dialog.show()
    }

    private fun showCustomDialogBoxSukses() {
        dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.activity_sukses)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val btnSukses = dialog.findViewById<ImageButton>(R.id.btn_sukses)
//
        btnSukses.setOnClickListener {
            dialog.dismiss()
            val intent = Intent(this, BerandaActivity::class.java)
            startActivity(intent)
            finish()
        }
        dialog.show()
    }
}