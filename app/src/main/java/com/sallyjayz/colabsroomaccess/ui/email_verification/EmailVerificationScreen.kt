package com.sallyjayz.colabsroomaccess.ui.email_verification

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentType
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sallyjayz.colabsroomaccess.R
import com.sallyjayz.colabsroomaccess.ui.email_verification.dialog.NotVerifiedDialog
import com.sallyjayz.colabsroomaccess.ui.email_verification.dialog.VerifyDialog


/**
 * Created by Salama Jatau on 04-Feb-26.
 */

@Composable
fun EmailVerificationTwoScreen() {

    val viewModel = viewModel<EmailVerificationTwoViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val focusRequesters = remember {
        List(6) { FocusRequester() } // (1..6).map { FocusRequester() }
    }
    val focusManager = LocalFocusManager.current
    val keyboardManager = LocalSoftwareKeyboardController.current

    val openAlertDialog = remember { mutableStateOf(false) }

    LaunchedEffect(state.focusedIndex) {
        state.focusedIndex?.let { index ->
            focusRequesters.getOrNull(index)?.requestFocus()
        }
    }

    LaunchedEffect(state.code, keyboardManager) {
        val allNumbersEntered = state.code.none { it == null }
        if (allNumbersEntered) {
            focusRequesters.forEach { it.freeFocus() }
            focusManager.clearFocus()
            keyboardManager?.hide()
        }
    }


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
            modifier = Modifier
                .padding(top = dimensionResource(R.dimen.sixteen))
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top) {

            Text(
                text= stringResource(R.string.email_verification),
                modifier = Modifier
                    .padding(top = dimensionResource(R.dimen.sixteen))
                    .fillMaxWidth()
            )

            Text(
                text= stringResource(R.string.email_verification_instruction),
                modifier = Modifier
                    .padding(
                        top = dimensionResource(R.dimen.eight),
                        bottom = dimensionResource(R.dimen.thirty_two)
                    )
                    .fillMaxWidth()
            )

            OtpScreen(
                openAlertDialog = openAlertDialog,
                state = state,
                focusRequesters = focusRequesters,
                onAction = { action ->
                    when (action) {
                        is OtpAction.OnEnterNumber -> {
                            if (action.number != null) {
                                focusRequesters[action.index].freeFocus()
                            }
                        }
                        else -> Unit
                    }
                    viewModel.onAction(action)
                },
                modifier = Modifier
                    .padding(bottom = dimensionResource(R.dimen.thirty_two))
            )

//            FilledButton(
//                onClick = {},
//                buttonText = R.string.confirm,
//                modifier = Modifier
//                    .fillMaxWidth()
//            )

            Text(
                text = stringResource(R.string.resend_code),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = dimensionResource(R.dimen.sixteen))
                    .fillMaxWidth()
            )

        }

    }

}

@Composable
fun OtpScreen(
    openAlertDialog: MutableState<Boolean>,
    state: OtpState,
    focusRequesters: List<FocusRequester>,
    onAction: (OtpAction) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally)
        ) {
            state.code.forEachIndexed { index, number ->
                OTPInputField(
                    number = number,
                    focusRequester = focusRequesters[index],
                    onFocusChanged = { isFocused ->
                        if (isFocused) {
                            onAction(OtpAction.OnChangeFieldFocused(index))
                        }
                    },
                    onNumberChanged = { newNumber ->
                        onAction(OtpAction.OnEnterNumber(newNumber, index))
                    },
                    onKeyboardBack = {
                        onAction(OtpAction.OnKeyboardBack)
                    },
                    modifier = Modifier
                        .semantics {
                            contentType = ContentType.SmsOtpCode // Enable SMS autofill
                        }
                        .weight(1f)
                        .aspectRatio(1f)
                )
            }
        }
        // this text shows whether the OTP is invalid or valid
        state.isValid?.let { isValid ->

            if (isValid) VerifyDialog() else NotVerifiedDialog()



            /*Text(
                text = if (isValid) "OTP is valid!" else "OTP is invalid!",
                color = if (isValid) Color.Green else Color.Red,
                fontSize = 16.sp
            )*/
        }
    }
}



@Preview(showBackground = true)
@Composable
fun EmailVerificationTwoScreenPreview() {
    EmailVerificationTwoScreen()
}