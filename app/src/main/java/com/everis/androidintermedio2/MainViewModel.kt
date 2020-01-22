package com.everis.androidintermedio2

import androidx.lifecycle.*
import kotlinx.coroutines.delay

class MainViewModel : ViewModel() {

    val initState = liveData {
        delay(3000)
        emit("Title")
    }

    private val _state = MutableLiveData<String>()
    val state: LiveData<String>?
        get() = _state

    fun started() {
        _state.value = "${_state.value} - started"
    }

    fun resumed() {
        _state.value = "${_state.value} - resumed"
    }

    fun onStart() {
        _state.value = "${_state.value} - onStart"
    }

    fun onPause() {
        _state.value = "${_state.value} - onPause"
    }

    fun onResume() {
        _state.value = "${_state.value} - onResume"
    }

    fun button() {
        _state.value = "${_state.value} - button"
    }
}