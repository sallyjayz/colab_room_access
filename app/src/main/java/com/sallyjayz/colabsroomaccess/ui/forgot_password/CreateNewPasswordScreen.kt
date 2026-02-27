package com.sallyjayz.colabsroomaccess.ui.forgot_password

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sallyjayz.colabsroomaccess.R
import com.sallyjayz.colabsroomaccess.ui.EditPasswordTextField
import com.sallyjayz.colabsroomaccess.ui.FilledButton
import com.sallyjayz.colabsroomaccess.ui.register.RegisterViewModel

/**
 * Created by Salama Jatau on 06-Feb-26.
 */

@Composable
fun CreateNewPasswordScreen(
    createNewPasswordViewModel: CreateNewPasswordViewModel,
    modifier: Modifier = Modifier
) {

    val uiState by createNewPasswordViewModel.uiState.collectAsStateWithLifecycle()
    var showPassword by remember { mutableStateOf(false) }

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

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(top = dimensionResource(R.dimen.sixteen)),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top) {

            Text(
                text= stringResource(R.string.create_new_password),
                modifier = Modifier
                    .padding(top = dimensionResource(R.dimen.sixteen))
                    .fillMaxWidth()
            )

            Text(
                text= stringResource(R.string.new_password_instruction),
                modifier = Modifier
                    .padding(
                        top = dimensionResource(R.dimen.eight),
                        bottom = dimensionResource(R.dimen.thirty_two)
                    )
                    .fillMaxWidth()
            )

            Text(
                text = stringResource(R.string.password),
                modifier = Modifier
                    .padding(bottom = dimensionResource(R.dimen.eight))
                    .fillMaxWidth()
            )

            EditPasswordTextField(
                label = R.string.enter_password,
                leadingIcon = Icons.Filled.Password,
                input = uiState.password,
                updateState = { createNewPasswordViewModel.updatePassword(it) },
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
                validatorHasErrors = createNewPasswordViewModel.passwordHasErrors,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Text(
                text = stringResource(R.string.confirm_password),
                modifier = Modifier
                    .padding(bottom = dimensionResource(R.dimen.eight))
                    .fillMaxWidth()
            )

            EditPasswordTextField(
                label = R.string.enter_password,
                leadingIcon = Icons.Filled.Password,
                input = uiState.confirmPassword,
                updateState = { createNewPasswordViewModel.updateConfirmPassword(it) },
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
                validatorHasErrors = createNewPasswordViewModel.passwordHasErrors,
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
                buttonText = R.string.confirm_password,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }


    }

}

@Preview
@Composable
fun CreateNewPasswordScreenPreview() {
    val createNewPasswordViewModel: CreateNewPasswordViewModel = viewModel< CreateNewPasswordViewModel>()
    CreateNewPasswordScreen(createNewPasswordViewModel)
}