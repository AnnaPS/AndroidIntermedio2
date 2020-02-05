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
    }


}
