package com.aleix_alfonso.recipeapp.screens.signup

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class SignUpPageViewModel:ViewModel(){

    private val _signUpState = MutableStateFlow<SignUpState>(SignUpState.Unauthenticated)
    val signUpState: MutableStateFlow<SignUpState> =_signUpState

    var isPasswordVisible by mutableStateOf(false)
        private set

    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set

    fun onVisibilityClick(){
        isPasswordVisible = !isPasswordVisible
    }

    fun onEmailChange(newEmail:String){
        email = newEmail
    }
    fun onPasswordChange(newPassword: String){
        password = newPassword


    }
}

sealed class SignUpState {
    object Unauthenticated :SignUpState()
    object Loading: SignUpState()
    object Authenticated : SignUpState()

}
