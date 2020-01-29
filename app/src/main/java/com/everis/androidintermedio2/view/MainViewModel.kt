package com.everis.androidintermedio2.view

import androidx.lifecycle.*
import com.everis.androidintermedio2.data.CategoryRepository
import com.everis.androidintermedio2.domain.GetCategory
import com.everis.androidintermedio2.model.Category
import kotlinx.coroutines.delay

class MainViewModel : ViewModel() {

    private val repository = CategoryRepository()
    private val getCategoryRepository = GetCategory(repository)

    private val stateCategory: MutableLiveData<List<Category>> = MutableLiveData()
    val _stateCategory: LiveData<List<Category>>
        get() = stateCategory

    fun getCategory() {
        stateCategory.value = getCategoryRepository()
    }
}