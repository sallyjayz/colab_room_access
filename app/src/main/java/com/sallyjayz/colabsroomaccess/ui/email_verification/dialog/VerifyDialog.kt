package com.sallyjayz.colabsroomaccess.ui.email_verification.dialog

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.sallyjayz.colabsroomaccess.R
import com.sallyjayz.colabsroomaccess.ui.FilledButton

/**
 * Created by Salama Jatau on 05-Feb-26.
 */

@Composable
fun VerifyDialog() {

    AlertDialog(
        icon = {
            Icon(painterResource(R.drawable.password_instruction_logo), contentDescription = null)
        },
        title = {
            Text(text = "Verified")
        },
        text = {
            Text(
                text = "Your email has been successfully verified",
                textAlign = TextAlign.Center
            )
        },
        onDismissRequest = {

        },
        confirmButton = {
            FilledButton(
                onClick = {},
                buttonText = R.string.proceed,
                modifier = Modifier
                    .fillMaxWidth()
            )
        },
        /*dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Dismiss")
            }
        }*/
    )

}

@Preview(showBackground = true)
@Composable
fun VerifyDialogPreview() {
    VerifyDialog()
}