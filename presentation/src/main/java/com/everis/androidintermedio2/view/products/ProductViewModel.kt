package com.everis.androidintermedio2.view.products

import android.os.Parcelable
import com.everis.androidintermedio2.BaseViewModel
import com.juntadeandalucia.ced.domain.ProductEntityView
import kotlinx.android.parcel.Parcelize

class ProducViewModel(): BaseViewModel<ProductState>() {
    override fun init() {}

    //TODO modifyProduct()
    //TODO deleteProduct()
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
    class SuccessDeleteState(): ProductState()
}
