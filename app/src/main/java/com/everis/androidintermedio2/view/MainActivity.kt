package com.everis.androidintermedio2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.everis.androidintermedio2.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: CategoryListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]


         adapter = CategoryListAdapter()
        rvList.adapter = adapter

        viewModel.getCategory()


        viewModel.state.observe(this, Observer (::updateList))
    }

     fun updateList(state : MainViewModel.ViewState?) {
         progress.visibility = if (state is MainViewModel.ViewState.Loading) View.VISIBLE else View.GONE

         when(state){
            is MainViewModel.ViewState.ShowList ->{
                adapter.categorys = state.categorys
                adapter.notifyDataSetChanged()
            }
        }
    }

}
