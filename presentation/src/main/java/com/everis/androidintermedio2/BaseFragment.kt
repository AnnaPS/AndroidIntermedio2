package com.everis.androidintermedio2

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

abstract class BaseFragment<STATE : Parcelable> : Fragment() {

    protected abstract val viewModel: BaseViewModel<STATE>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(getLayout(), container, false)


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initObservers()
    }

    private fun initObservers() {
        viewModel.initObserver(owner = viewLifecycleOwner,state = {manageState(it)})
    }

   abstract fun getLayout(): Int

    protected abstract fun manageState(state: STATE)

}