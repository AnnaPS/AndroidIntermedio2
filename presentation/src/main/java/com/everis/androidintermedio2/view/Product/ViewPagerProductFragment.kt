package com.everis.androidintermedio2.view.Product


import androidx.fragment.app.Fragment
import com.everis.androidintermedio2.R
import com.everis.androidintermedio2.view.base.BaseFragment
import com.everis.androidintermedio2.view.products.ProducViewModel
import com.everis.androidintermedio2.view.products.ProductState
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class ViewPagerProductFragment : BaseFragment<ProductState>() {
    override val viewModel by viewModel<ProducViewModel>()

    override fun getLayout(): Int =
        R.layout.fragment_view_pager_product

    override fun manageState(state: ProductState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
