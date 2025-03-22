package com.aleix_alfonso.recipeapp.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel : ViewModel() {

    private val _authState = MutableStateFlow<AuthState>(AuthState.Unauthenticated)
    val authState: MutableStateFlow<AuthState> = _authState


    var auth: FirebaseAuth = Firebase.auth

    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set
    var isLoading by mutableStateOf(false)
        private set
    var isPasswordVisible by mutableStateOf(false)
        private set

    fun onEmailChange(newEmail: String) {
        email = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        password = newPassword
    }

    fun onVisibilityClick() {
        isPasswordVisible = !isPasswordVisible

    }

    fun login(email: String, password: String) {
        if (email.isBlank() || password.isBlank()) {
            authState.value = AuthState.Error("Email and password cannot be empty")
            return
        }
        authState.value = AuthState.Loading
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful){
                authState.value = AuthState.Authenticated
            }else{
                authState.value = AuthState.Error(task.exception?.message ?: "Unknown error")
            }
        }

    }


}

sealed class AuthState {
    object Authenticated : AuthState()
    object Unauthenticated : AuthState()
    object Loading : AuthState()
    data class Error(val message: String) : AuthState()
}