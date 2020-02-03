package com.everis.androidintermedio2.view

import androidx.lifecycle.*
import com.juntadeandalucia.ced.domain.Category
import com.juntadeandalucia.ced.domain.CategoryError
import com.juntadeandalucia.ced.domain.useCases.GetCategory
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
private val getCategory: GetCategory
)
: ViewModel() {

    sealed class  ViewState{
        object Loading : ViewState()
        class ShowList(val categorys: List<Category>): ViewState()
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

    private fun handleError(categoryError: CategoryError) {
        _state.value = ViewState.Error(categoryError.error)
    }

    private fun handleSuscces(list: List<Category>) {
        _state.value =ViewState.ShowList(list)
    }
}