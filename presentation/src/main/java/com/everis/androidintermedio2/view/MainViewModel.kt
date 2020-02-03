package com.everis.androidintermedio2.view

import androidx.lifecycle.*
import com.juntadeandalucia.ced.domain.Category
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
            _state.value =ViewState.ShowList(getCategory.invoke())
        }
    }
}