package com.everis.androidintermedio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    init {
        lifecycleScope.launch {
            whenCreated {
                viewModel = ViewModelProviders.of(this@MainActivity)[MainViewModel::class.java]

                viewModel.initState.observe(this@MainActivity, Observer {
                    it?.let {
                        etTitle?.text = it
                    }
                })

                viewModel.state?.observe(this@MainActivity, Observer {
                    it?.let {
                        etConsole?.text = it
                    }
                })

                bTest?.setOnClickListener {
                    viewModel.button()
                }
            }

            whenStarted {
                viewModel.started()
            }

            whenResumed {
                viewModel.resumed()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        viewModel.onStart()

        super.onStart()
    }

    override fun onPause() {
        viewModel.onPause()

        super.onPause()
    }

    override fun onResume() {
        viewModel.onResume()

        super.onResume()
    }
}
