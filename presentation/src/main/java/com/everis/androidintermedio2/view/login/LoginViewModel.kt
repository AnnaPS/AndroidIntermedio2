package com.everis.androidintermedio2.view.login

import android.os.Parcelable
import androidx.lifecycle.viewModelScope
import com.everis.androidintermedio2.view.base.BaseViewModel
import com.juntadeandalucia.ced.domain.ErrorData
import com.juntadeandalucia.ced.domain.UserRequest
import com.juntadeandalucia.ced.domain.UserResponse
import com.juntadeandalucia.ced.domain.useCases.LoginUseCase
import kotlinx.android.parcel.Parcelize
import kotlinx.coroutines.launch

class LoginViewModel(
    private val getLogin: LoginUseCase
): BaseViewModel<LoginState>() {
    override fun init() {}

    fun login(user: UserRequest) {
        viewModelScope.launch {
            state.value = LoginState.LoadingState
            val res = getLogin.login(user)
            res.fold(::handleError,::handleSuscces)

        }
    }


    private fun handleError(loginError: ErrorData) {
        state.value = LoginState.ErrorState(loginError.error)
    }

    private fun handleSuscces(user: UserResponse) {
        state.value = LoginState.SuccessState(user)
    }
}

sealed class LoginState: Parcelable {
    @Parcelize
    object LoadingState: LoginState()

    @Parcelize
    class ErrorState(val error: String): LoginState()

    @Parcelize
    class SuccessState (val user: UserResponse): LoginState()
}