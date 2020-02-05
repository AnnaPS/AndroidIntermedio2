package com.everis.androidintermedio2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.everis.androidintermedio2.R
import com.everis.androidintermedio2.view.products.ProductListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel <MainViewModel>()
    private lateinit var adapter: ProductListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//         adapter = ProductListAdapter()
////        rvList.adapter = adapter
//
//        viewModel.getCategory()
//
//
//        viewModel.state.observe(this, Observer (::updateList))
    }

//     fun updateList(state : MainViewModel.ViewState?) {
//         progress.visibility = if (state is MainViewModel.ViewState.Loading) View.VISIBLE else View.GONE
//
//         when(state){
//            is MainViewModel.ViewState.ShowList ->{
//                adapter.categorys = state.categorys
//                adapter.notifyDataSetChanged()
//            }
//
//             is MainViewModel.ViewState.Error ->{
//                 tvError.visibility = View.VISIBLE
//                 tvError.text = state.error
//             }
//        }
//    }

}
