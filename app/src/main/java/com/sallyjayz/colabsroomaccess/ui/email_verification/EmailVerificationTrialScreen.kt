package com.sallyjayz.colabsroomaccess.ui.email_verification

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentType
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sallyjayz.colabsroomaccess.R
import com.sallyjayz.colabsroomaccess.ui.FilledButton


/**
 * Created by Salama Jatau on 04-Feb-26.
 */

@Composable
fun EmailVerificationTrialScreen() {

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

            OtpTextField()

            FilledButton(
                onClick = {},
                buttonText = R.string.confirm,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Text(text = stringResource(R.string.resend_code))

        }

    }

}

@Composable
fun OtpTextField() {
    Column {
        Text("OTP Field")
        Spacer(modifier = Modifier.height(8.dp))
        val state = rememberTextFieldState()
        BasicTextField(
            modifier = Modifier.semantics {
                contentType = ContentType.SmsOtpCode // Enable SMS autofill
            },
            state = state,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            lineLimits = TextFieldLineLimits.SingleLine,
            inputTransformation = InputTransformation.maxLength(6),
            decorator = { innerTextField ->
                val text = state.text
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    repeat(6) {
                        Digit(
                            number = text.getOrNull(it) ?: ' ',
                            showCursor = it == text.length
                        )
                    }
                }
            }
        )
    }
}

@Composable
fun Digit(
    number: Char,
    showCursor: Boolean
) {
    Box(
        Modifier
            .size(48.dp)
            .border(1.5.dp, Color(0x00000000))
            .background(Color(0xFFFFFFFF))
    ) {
        Text(
            text = number.toString(),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.Center)
        )

        if (showCursor) {
            val infiniteTransition = rememberInfiniteTransition(label = "Cursor Animation")
            val alpha by infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(500),
                    repeatMode = RepeatMode.Reverse
                ),
                label = "Cursor Alpha"
            )
            Column(
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Box(
                    Modifier
                        .width(16.dp)
                        .height(1.dp)
                        .background(Color(0x00000000).copy(alpha = alpha))
                )
                Spacer(modifier = Modifier.padding(4.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmailVerificationTrialScreenPreview() {
    EmailVerificationTrialScreen()
}