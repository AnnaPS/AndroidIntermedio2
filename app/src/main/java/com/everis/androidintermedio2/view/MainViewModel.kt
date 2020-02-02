package com.everis.androidintermedio2.view

import androidx.lifecycle.*
import com.everis.androidintermedio2.data.CategoryRepository
import com.everis.androidintermedio2.domain.GetCategory
import com.everis.androidintermedio2.model.Category
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    sealed class  ViewState{
        object Loading : ViewState()
        class ShowList(val categorys: List<Category>): ViewState()
    }

    private val repository = CategoryRepository()
    private val getCategoryRepository = GetCategory(repository)


    private  val _state = MutableLiveData<ViewState>()


    val state : LiveData<ViewState>
        get(){
            return _state
        }

    fun getCategory() {

        viewModelScope.launch {
            _state.value = ViewState.Loading
            delay(3000)
            _state.value =ViewState.ShowList(getCategoryRepository())
        }
    }
}