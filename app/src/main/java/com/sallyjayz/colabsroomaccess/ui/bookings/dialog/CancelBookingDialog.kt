package com.sallyjayz.colabsroomaccess.ui.bookings.dialog

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.sallyjayz.colabsroomaccess.R
import com.sallyjayz.colabsroomaccess.ui.FilledButton

/**
 * Created by Salama Jatau on 09-Mar-26.
 */

@Composable
fun CancelBookingDialog(
    openAlertDialog: MutableState<Boolean>
) {

    if (openAlertDialog.value) {
        AlertDialog(
            icon = {
                Icon(painterResource(R.drawable.password_instruction_logo), contentDescription = null)
            },
            title = {
                Text(text = "Cancel Booking?")
            },
            text = {
                Text(
                    text = "Are you sure you want to cancel this\nbooking?",
                    textAlign = TextAlign.Center
                )
            },
            onDismissRequest = {
                openAlertDialog.value = false
            },
            confirmButton = {
                FilledButton(
                    onClick = {
//                        openAlertDialog.value = false
                    },
                    buttonText = R.string.no_keep_booking,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            },
            dismissButton = {
                FilledButton(
                    onClick = {
//                        openAlertDialog.value = false
                    },
                    buttonText = R.string.yes_cancel_booking,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        )
    }
}

/*
@Preview(showBackground = true)
@Composable
fun CancelBookingDialogPreview() {
    CancelBookingDialog()
}*/
