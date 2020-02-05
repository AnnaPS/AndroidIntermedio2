package com.everis.androidintermedio2.view.Product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.everis.androidintermedio2.R

class ViewPagerProductAdapter : RecyclerView.Adapter<ViewPagerProductAdapter.PagerViewHolder>() {
    var images : MutableList<String> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        return PagerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_viewpager_layout,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind()
    }

    inner class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
        fun bind(){

        }

    }
}