package com.everis.androidintermedio2.view.products

import android.os.Parcelable
import com.everis.androidintermedio2.BaseViewModel
import com.juntadeandalucia.ced.domain.ProductEntityView
import kotlinx.android.parcel.Parcelize

class ProductListViewModel(): BaseViewModel<ProductListState>() {
    override fun init() {}

    //TODO getProductList()
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
