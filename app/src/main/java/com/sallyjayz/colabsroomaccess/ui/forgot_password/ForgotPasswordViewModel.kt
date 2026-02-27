package com.sallyjayz.colabsroomaccess.ui.forgot_password

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

/**
 * Created by Salama Jatau on 06-Feb-26.
 */
class ForgotPasswordViewModel: ViewModel() {

    var email by mutableStateOf("")
        private set

    val emailHasErrors by derivedStateOf {
        if (email.isNotEmpty()) {
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        } else {
            false
        }
    }

    fun updateEmail(inputEmail: String) {
        email = inputEmail
    }

}