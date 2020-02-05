package com.everis.androidintermedio2.view.login


import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.everis.androidintermedio2.view.base.BaseFragment

import com.everis.androidintermedio2.R
import com.juntadeandalucia.ced.domain.UserRequest
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : BaseFragment<LoginState>() {

    override val viewModel by viewModel<LoginViewModel>()

    override fun getLayout(): Int = R.layout.fragment_login

    override fun manageState(state: LoginState) {
       when(state){
           is LoginState.LoadingState -> {
               //TODO
           }
           is LoginState.SuccessState -> {
               findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToListProductFragment())
           }
           is LoginState.ErrorState -> {
               Toast.makeText(context, state.error,Toast.LENGTH_SHORT).show()
           }
       }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bt_login.setOnClickListener {
            var user = UserRequest(userName = et_user.text.toString(),password = et_password.text.toString())
            viewModel.login(user)
        }
    }

}
