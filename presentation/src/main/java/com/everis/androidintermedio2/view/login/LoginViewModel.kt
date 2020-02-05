package com.everis.androidintermedio2.view.login

import android.os.Parcelable
import com.everis.androidintermedio2.BaseViewModel
import com.juntadeandalucia.ced.domain.UserEntityView
import kotlinx.android.parcel.Parcelize

class LoginViewModel(): BaseViewModel<LoginState>() {
    override fun init() {}

    //TODO login()
}

sealed class LoginState: Parcelable {
    @Parcelize
    object LoadingState: LoginState()

    @Parcelize
    class ErrorState(val error: String): LoginState()

    @Parcelize
    class SuccessState (val user: UserEntityView): LoginState()
}