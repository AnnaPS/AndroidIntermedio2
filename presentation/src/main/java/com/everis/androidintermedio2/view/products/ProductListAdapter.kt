package com.everis.androidintermedio2.view.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.everis.androidintermedio2.R
import com.juntadeandalucia.ced.domain.ProductEntityData
import com.juntadeandalucia.ced.domain.ProductEntityView
import kotlinx.android.synthetic.main.fragment_detail_product.view.*
import kotlinx.android.synthetic.main.item_layout.view.*
import kotlinx.android.synthetic.main.item_layout.view.tv_description
import kotlinx.android.synthetic.main.item_layout.view.tv_title

class ProductListAdapter : RecyclerView.Adapter<ProductListAdapter.ItemViewHolder>() {

    var productList: List<ProductEntityView> = emptyList()

    private lateinit var callback : OnItemSelected

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
       return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {

        fun bind(product: ProductEntityView) = with(itemView) {

            //iv_item.setImageDrawable(category.imageList[0])
            tv_title.text = product.title
            tv_description.text = product.subtitle

            bt_remove.setOnClickListener {
                callback?.onDeleteItem(product)
            }

        }
    }

    interface OnItemSelected{
        fun onDeleteItem(product: ProductEntityView)
    }


}