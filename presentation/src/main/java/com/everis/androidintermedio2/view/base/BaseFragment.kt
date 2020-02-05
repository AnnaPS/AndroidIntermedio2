package com.everis.androidintermedio2.view.base

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment<STATE : Parcelable> : Fragment() {

    protected abstract val viewModel: BaseViewModel<STATE>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(getLayout(), container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    private fun initObservers() {
        viewModel.initObserver(owner = viewLifecycleOwner,state = {manageState(it)})
    }

   abstract fun getLayout(): Int

    protected abstract fun manageState(state: STATE)

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clearObservers(viewLifecycleOwner)
    }

}