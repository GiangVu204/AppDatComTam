package com.example.appdatcomtam

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState

    private val _userRole = MutableStateFlow<UserRole>(UserRole.USER)
    val userRole: StateFlow<UserRole> = _userRole

    fun onUsernameChange(newUsername: String) {
        _username.value = newUsername
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
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
