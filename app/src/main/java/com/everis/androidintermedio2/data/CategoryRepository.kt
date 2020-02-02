package com.everis.androidintermedio2.data

import com.everis.androidintermedio2.model.Category
import kotlinx.coroutines.delay

class CategoryRepository {

    private val categorys: MutableList<Category> = mutableListOf()

    private val colors = intArrayOf(
        android.R.color.black,
        android.R.color.holo_red_light,
        android.R.color.holo_blue_dark,
        android.R.color.holo_purple
    )

    private val icon = intArrayOf(
        android.R.drawable.ic_media_play,
        android.R.drawable.ic_dialog_alert,
        android.R.drawable.ic_dialog_map,
        android.R.drawable.ic_media_next

    )

  suspend  fun getCategory(): List<Category>{
        for(i in 0..3){
            categorys.add(Category("Category $i",colors[i],icon[i]))
        }

        return categorys
    }
}