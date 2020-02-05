package com.everis.androidintermedio2.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.everis.androidintermedio2.R
import com.juntadeandalucia.ced.domain.ProductEntityData
import kotlinx.android.synthetic.main.item_page.view.*

class ProductListAdapter : RecyclerView.Adapter<ProductListAdapter.ItemViewHolder>() {

    var categorys: List<ProductEntityData> = emptyList()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
       return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_page,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = categorys.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(categorys[position])
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {

        fun bind(category: ProductEntityData) = with(itemView) {

//                tvAbout.text = category.name


        }
    }




}