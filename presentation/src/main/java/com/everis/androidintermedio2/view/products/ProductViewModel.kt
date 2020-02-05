package com.everis.androidintermedio2.view.products

import android.os.Parcelable
import androidx.lifecycle.viewModelScope
import com.everis.androidintermedio2.BaseViewModel
import com.juntadeandalucia.ced.domain.ErrorData
import com.juntadeandalucia.ced.domain.ProductEntityView
import com.juntadeandalucia.ced.domain.useCases.DeleteProduct
import kotlinx.android.parcel.Parcelize
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProducViewModel(
    val deleteProduct : DeleteProduct
): BaseViewModel<ProductState>() {
    override fun init() {}

    //TODO modifyProduct()
    //TODO deleteProduct()


    fun deleteProduct(product: ProductEntityView){
        viewModelScope.launch {
            state.value = ProductState.LoadingState
            delay(3000)
//            val res = deleteProduct.deleteProduct(product)
//            res.fold(::handleError,::handleSuscces)

        }
    }

    private fun handleError(deleteProductError: ErrorData) {
        state.value = ProductState.ErrorDeleteState(deleteProductError.error)
    }

    private fun handleSuscces(productList:List<ProductEntityView>) {
        state.value = ProductState.SuccessDeleteState(productList)
    }
}

sealed class ProductState: Parcelable {

    @Parcelize
    object LoadingState: ProductState()

    @Parcelize
    class ErrorModifyState(val error: String): ProductState()

    @Parcelize
    class SuccessModifyState(val product: ProductEntityView): ProductState()

    @Parcelize
    class ErrorDeleteState(val error: String): ProductState()

    @Parcelize
    class SuccessDeleteState(val productList: List<ProductEntityView>): ProductState()
}
