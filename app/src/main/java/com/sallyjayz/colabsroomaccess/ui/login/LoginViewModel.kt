package com.sallyjayz.colabsroomaccess.ui.login

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

/**
 * Created by Salama Jatau on 30-Jan-26.
 */
class LoginViewModel: ViewModel() {

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

    fun updateEmail(inputEmail: String) {
        email = inputEmail
    }

    fun updatePassword(inputPassword: String) {
        password = inputPassword
    }
}