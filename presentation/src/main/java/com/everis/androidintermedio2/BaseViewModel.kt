package com.everis.androidintermedio2

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<State: Parcelable>: ViewModel() {

    protected var state: MutableLiveData<State> = MutableLiveData()

    fun config (savedInstanceState: Bundle?) {
        savedInstanceState?.getParcelable<State>(STATE)?.let { state ->
            restore(state = state)
        } ?: run {
            init()
        }
    }

    protected fun restore (state: State) {
        this.state.value = state
    }

    protected abstract fun init ()

    fun saveState (outState: Bundle) {
        outState.putParcelable(STATE, state.value)
    }

    fun initObserver (owner: LifecycleOwner, state: (State) -> Unit) {
        this.state.observe(owner, Observer {
            it?.let {
                state(it)
            }
        })
    }

    fun clearObservers (owner: LifecycleOwner) {
        state.removeObservers(owner)
    }

    companion object {
        private const val STATE = "STATE"
    }

}