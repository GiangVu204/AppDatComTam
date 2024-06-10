package com.example.appdatcomtam

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(context: Context) : ViewModel() {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("login_prefs", Context.MODE_PRIVATE)

    private val _username = MutableStateFlow(sharedPreferences.getString("username", "") ?: "")
    val username: StateFlow<String> = _username

    private val _password = MutableStateFlow(sharedPreferences.getString("password", "") ?: "")
    val password: StateFlow<String> = _password

    private val _rememberMe = MutableStateFlow(sharedPreferences.getBoolean("remember_me", false))
    val rememberMe: StateFlow<Boolean> = _rememberMe

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState

    private val _userRole = MutableStateFlow<UserRole>(UserRole.USER)
    val userRole: StateFlow<UserRole> = _userRole

    fun onUsernameChange(newUsername: String) {
        _username.value = newUsername
        saveLoginDetails()
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
        saveLoginDetails()
    }

    fun onRememberMeChange(newRememberMe: Boolean) {
        _rememberMe.value = newRememberMe
        saveLoginDetails()
    }

    private fun saveLoginDetails() {
        with(sharedPreferences.edit()) {
            putString("username", _username.value)
            putString("password", _password.value)
            putBoolean("remember_me", _rememberMe.value)
            apply()
        }
    }

    fun login() {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            // Giả lập việc kiểm tra thông tin đăng nhập và quyền
            if (_username.value == "admin" && _password.value == "123") {
                _userRole.value = UserRole.ADMIN
                _loginState.value = LoginState.Success
            } else if (_username.value == "user" && _password.value == "123") {
                _userRole.value = UserRole.USER
                _loginState.value = LoginState.Success
            } else if (_username.value.isEmpty() && _password.value.isEmpty()) {
                _loginState.value =
                    LoginState.Error("Bạn không được để trống username hoặc password")
            } else if (_username.value.isEmpty()) {
                _loginState.value = LoginState.Error("Bạn không được để trống username")
            } else if (_password.value.isEmpty()) {
                _loginState.value = LoginState.Error("Bạn không được để trống password")
            } else {
                _loginState.value = LoginState.Error("Thông tin đăng nhập không chính xác")
            }
        }
    }
}

sealed class LoginState {
    object Idle : LoginState()
    object Loading : LoginState()
    object Success : LoginState()
    data class Error(val message: String) : LoginState()
}

enum class UserRole {
    ADMIN,
    USER
}
