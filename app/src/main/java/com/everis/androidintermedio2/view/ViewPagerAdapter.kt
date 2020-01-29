package com.everis.androidintermedio2.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.everis.androidintermedio2.R
import com.everis.androidintermedio2.model.Category
import kotlinx.android.synthetic.main.item_page.view.*

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {

    private val categorys = mutableListOf<Category>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
       return PagerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_page,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = categorys.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(categorys[position])
    }

    inner class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {

        fun bind(category: Category) = with(itemView) {

                tvTitle.text = category.name
                ivImage.setImageResource(category.icon)
                container.setBackgroundResource(category.color)

        }
    }



    fun refresh(_categorys:List<Category>){
        categorys.clear()
        categorys.addAll(_categorys)
        notifyDataSetChanged()
    }

}