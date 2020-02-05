package com.everis.androidintermedio2


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.everis.androidintermedio2.view.base.BaseFragment
import com.everis.androidintermedio2.view.products.ProductListAdapter
import com.everis.androidintermedio2.view.products.ProductListState
import com.everis.androidintermedio2.view.products.ProductListViewModel
import kotlinx.android.synthetic.main.fragment_list_product.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class ListProductFragment : BaseFragment<ProductListState>() {
    private var adapter = ProductListAdapter()

    override val viewModel by viewModel<ProductListViewModel>()

    override fun getLayout(): Int = R.layout.fragment_list_product

    override fun manageState(state: ProductListState) {
        when(state){
            is ProductListState.SuccessState ->{
                rv_elements.layoutManager = LinearLayoutManager(context)
                rv_elements.adapter= adapter
                adapter.also {
                    it.itemPressed = {
                        findNavController().navigate(ListProductFragmentDirections.actionListProductFragmentToDetailProductFragment())
                    }
                }
                adapter.categorys = state.productList
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getProducts()

    }

}
