package com.sallyjayz.colabsroomaccess.ui.forgot_password

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sallyjayz.colabsroomaccess.R
import com.sallyjayz.colabsroomaccess.ui.EditTextField
import com.sallyjayz.colabsroomaccess.ui.FilledButton

/**
 * Created by Salama Jatau on 06-Feb-26.
 */

@Composable
fun ForgotPasswordScreen() {

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

        val forgotPasswordViewModel: ForgotPasswordViewModel = viewModel<ForgotPasswordViewModel>()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = dimensionResource(R.dimen.sixteen)),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top) {

            Text(
                text= stringResource(R.string.forgot_password),
                modifier = Modifier
                    .padding(top = dimensionResource(R.dimen.sixteen))
                    .fillMaxWidth()
            )

            Text(
                text= stringResource(R.string.forgot_password_instruction),
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
                input = forgotPasswordViewModel.email,
                updateState = { input -> forgotPasswordViewModel.updateEmail(input) },
                validatorHasErrors = forgotPasswordViewModel.emailHasErrors,
                modifier = Modifier
                    .fillMaxWidth()
            )

            FilledButton(
                onClick = {},
                buttonText = R.string.recover_password,
                modifier = Modifier
                    .fillMaxWidth()
            )

        }

    }

}

@Preview(showBackground = true)
@Composable
fun ForgotPasswordScreenPreview() {
    ForgotPasswordScreen()
}