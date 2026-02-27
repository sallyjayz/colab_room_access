package com.sallyjayz.colabsroomaccess.ui.forgot_password

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.sallyjayz.colabsroomaccess.ui.register.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Created by Salama Jatau on 06-Feb-26.
 */

data class UiState(
    val password: String = "",
    val confirmPassword: String  = ""
)

class CreateNewPasswordViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    var password by mutableStateOf("")
        private set

    val passwordHasErrors by derivedStateOf {
        if (password.isNotEmpty()) {
            true  /*TODO */
        } else {
            false
        }
    }


    fun updatePassword(inputPassword: String) = _uiState.update { it.copy(
        password = inputPassword
    ) }

    fun updateConfirmPassword(inputConfirmPassword: String) = _uiState.update { it.copy(
        confirmPassword = inputConfirmPassword
    ) }

}