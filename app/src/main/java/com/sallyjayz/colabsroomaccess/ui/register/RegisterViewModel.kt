package com.sallyjayz.colabsroomaccess.ui.register

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Created by Salama Jatau on 02-Feb-26.
 */

data class UiState(
    val fullName: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String  = ""
)
class RegisterViewModel: ViewModel()  {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    var email by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    val emailHasErrors by derivedStateOf {
        if (email.isNotEmpty()) {
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        } else {
            false
        }
    }

    val passwordHasErrors by derivedStateOf {
        if (password.isNotEmpty()) {
            true  /*TODO */
        } else {
            false
        }
    }

    /*fun updateEmail(inputEmail: String) {
        email = inputEmail
    }

    fun updatePassword(inputPassword: String) {
        password = inputPassword
    }*/

    fun updateFullName(fullName: String) = _uiState.update { it.copy(
        fullName = fullName
    ) }

    fun updateEmail(inputEmail: String) = _uiState.update { it.copy(
        email = inputEmail
    ) }

    fun updatePassword(inputPassword: String) = _uiState.update { it.copy(
        password = inputPassword
    ) }

    fun updateConfirmPassword(inputConfirmPassword: String) = _uiState.update { it.copy(
        confirmPassword = inputConfirmPassword
    ) }

}