package com.everis.androidintermedio2.view.products


import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.everis.androidintermedio2.BaseFragment
import com.everis.androidintermedio2.R
import com.juntadeandalucia.ced.domain.ProductEntityView
import kotlinx.android.synthetic.main.fragment_detail_product.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailProductFragment : BaseFragment<ProductState>() {

    override val viewModel by viewModel<ProducViewModel>()

    override fun getLayout(): Int = R.layout.fragment_detail_product
    private val args: DetailProductFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {

        bt_remove.setOnClickListener {
            var list = emptyList<String>()
//            var product = ProductEntityView(title = args.productTitle, subtitle = args.productSubtitle, )
            viewModel.deleteProduct(product)
        }
    }

    override fun manageState(state: ProductState) {
    }


}
