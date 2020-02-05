package com.everis.androidintermedio2.view.products

import android.os.Parcelable
import androidx.lifecycle.viewModelScope
import com.everis.androidintermedio2.view.base.BaseViewModel
import com.juntadeandalucia.ced.domain.ErrorData
import com.juntadeandalucia.ced.domain.ProductEntityView
import com.juntadeandalucia.ced.domain.useCases.GetProduct
import kotlinx.android.parcel.Parcelize
import kotlinx.coroutines.launch

class ProductListViewModel(var getProduct: GetProduct): BaseViewModel<ProductListState>() {
    override fun init() {}

    fun getProducts(){
        viewModelScope.launch {
            state.value = ProductListState.LoadingState
            val res = getProduct.invoke(true)
            res.fold(::handleError,::handleSuscces)

        }
    }

    private fun handleError(error: ErrorData) {
        state.value = ProductListState.ErrorState(error.error)
    }

    private fun handleSuscces(response: MutableList<ProductEntityView>) {
        state.value = ProductListState.SuccessState(response)
    }
}

sealed class ProductListState: Parcelable {

    @Parcelize
    object LoadingState: ProductListState()

    @Parcelize
    class ErrorState(val error: String): ProductListState()

    @Parcelize
    class EmptyListState(): ProductListState()

    @Parcelize
    class SuccessState(val productList: List<ProductEntityView>): ProductListState()
}
