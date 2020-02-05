package com.everis.androidintermedio2.view

import androidx.lifecycle.*
import com.juntadeandalucia.ced.domain.ProductEntityData
import com.juntadeandalucia.ced.domain.ErrorData
import com.juntadeandalucia.ced.domain.ProductEntityView
import com.juntadeandalucia.ced.domain.useCases.GetProduct
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
private val getCategory: GetProduct
)
: ViewModel() {

    sealed class  ViewState{
        object Loading : ViewState()
        class ShowList(val categorys: MutableList<ProductEntityData>): ViewState()
        class Error(val error: String): ViewState()
    }


    private  val _state = MutableLiveData<ViewState>()


    val state : LiveData<ViewState>
        get(){
            return _state
        }

    fun getCategory() {

        viewModelScope.launch {
            _state.value = ViewState.Loading
            delay(3000)
            val res =getCategory.invoke(true)
            res.fold(::handleError,::handleSuscces)

        }
    }

    private fun handleError(categoryError: ErrorData) {
        _state.value = ViewState.Error(categoryError.error)
    }

    private fun handleSuscces(list: MutableList<ProductEntityView>) {
        //_state.value =ViewState.ShowList(list)
    }
}