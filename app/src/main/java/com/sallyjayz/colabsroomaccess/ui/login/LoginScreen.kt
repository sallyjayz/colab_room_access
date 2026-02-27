package com.sallyjayz.colabsroomaccess.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sallyjayz.colabsroomaccess.R
import com.sallyjayz.colabsroomaccess.ui.EditPasswordTextField
import com.sallyjayz.colabsroomaccess.ui.EditTextField
import com.sallyjayz.colabsroomaccess.ui.FilledButton

/**
 * Created by Salama Jatau on 30-Jan-26.
 */

@Composable
fun LoginScreen() {

    Column (
        modifier = Modifier
            .statusBarsPadding()
            .padding(
                horizontal = dimensionResource(R.dimen.forty),
                vertical = dimensionResource(R.dimen.twenty)
            )
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.colab_logo),
            contentDescription = null
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
        ){
            LoginSection(Modifier.align(Alignment.TopCenter))
            SignUpQuestion(modifier = Modifier.align(Alignment.BottomCenter))
        }

    }

}

@Composable
fun LoginSection(modifier: Modifier = Modifier) {

    val loginViewModel: LoginViewModel = viewModel<LoginViewModel>()
    var showPassword by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.padding(top = dimensionResource(R.dimen.sixteen)),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top) {

        Text(
            text= stringResource(R.string.welcome_back),
            modifier = Modifier
                .padding(top = dimensionResource(R.dimen.sixteen))
                .fillMaxWidth()
        )

        Text(
            text= stringResource(R.string.login_instruction),
            modifier = Modifier
                .padding(
                    top = dimensionResource(R.dimen.eight),
                    bottom = dimensionResource(R.dimen.thirty_two)
                )
                .fillMaxWidth()
        )

        Text(
            text = stringResource(R.string.email),
            modifier = Modifier
                .padding(bottom = dimensionResource(R.dimen.eight))
                .fillMaxWidth()
        )

        EditTextField(
            label = R.string.enter_email,
            leadingIcon = Icons.Filled.Email,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            input = loginViewModel.email,
            updateState = { input -> loginViewModel.updateEmail(input) },
            validatorHasErrors = loginViewModel.emailHasErrors,
            modifier = Modifier
                .fillMaxWidth()
        )

        Row(
            modifier = Modifier
                .padding(bottom = dimensionResource(R.dimen.eight))
                .fillMaxWidth()
        ) {
            Text(stringResource(R.string.password))

            Text(stringResource(R.string.forgot_password),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End)
            )
        }

        EditPasswordTextField(
            label = R.string.enter_password,
            leadingIcon = Icons.Filled.Password,
            input = loginViewModel.password,
            updateState = { input -> loginViewModel.updatePassword(input) },
            trailingIcon = if (showPassword) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            },
            onClick = {showPassword = !showPassword},
            contentDescription = if (showPassword) stringResource(R.string.hide_password) else stringResource(
                R.string.show_password
            ),
            visualTransformation = if (showPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            validatorHasErrors = loginViewModel.passwordHasErrors,
            modifier = Modifier
                .fillMaxWidth()
        )

        Row(modifier = Modifier
            .padding(bottom = dimensionResource(R.dimen.thirty_two))
            .fillMaxWidth()){

            Icon(
                painter = painterResource(R.drawable.password_instruction_logo),
                contentDescription = null,
                modifier = modifier.padding(top = dimensionResource(R.dimen.two), end = dimensionResource(R.dimen.four))
            )

            Text(text = stringResource(R.string.password_instruction))
        }

        FilledButton(
            onClick = {},
            buttonText = R.string.sign_in,
            modifier = Modifier
                .fillMaxWidth()
        )

    }
}

@Composable
fun SignUpQuestion(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier
    ) {
        Text(text = stringResource(R.string.no_account), modifier = modifier.padding(bottom = dimensionResource(R.dimen.eight)))
        FilledTonalButton(onClick = {}) {
            Text(
                text = stringResource(R.string.sign_up)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}