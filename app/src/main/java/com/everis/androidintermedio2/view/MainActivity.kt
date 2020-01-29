package com.everis.androidintermedio2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.everis.androidintermedio2.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]



        view_pager2.adapter =
            ViewPagerAdapter()

        viewModel.getCategory()


        viewModel._stateCategory.observe(this, Observer {
            it?.let {
                (view_pager2.adapter as ViewPagerAdapter).refresh(it)
            }
        })
         view_pager2.orientation = ViewPager2.ORIENTATION_VERTICAL

    }

}
