package com.afebrii.fieldon.ui.detailLapangan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.afebrii.fieldon.R
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdaptor(private val images:List<Int>): RecyclerView.Adapter<ViewPagerAdaptor.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val  imageView: ImageView = itemView.findViewById(R.id.ivImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdaptor.ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerAdaptor.ViewPagerViewHolder, position: Int) {
        val curImage = images[position]
        holder.imageView.setImageResource(curImage)
    }


    override fun getItemCount(): Int {
        return images.size
    }

}