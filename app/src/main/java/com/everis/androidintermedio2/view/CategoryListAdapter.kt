package com.everis.androidintermedio2.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.everis.androidintermedio2.R
import com.everis.androidintermedio2.model.Category
import kotlinx.android.synthetic.main.item_page.view.*

class CategoryListAdapter : RecyclerView.Adapter<CategoryListAdapter.ItemViewHolder>() {

    var categorys: List<Category> = emptyList()



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

        fun bind(category: Category) = with(itemView) {

                tvAbout.text = category.name
                ivImage.setImageResource(category.icon)
                container.setBackgroundResource(category.color)

        }
    }




}