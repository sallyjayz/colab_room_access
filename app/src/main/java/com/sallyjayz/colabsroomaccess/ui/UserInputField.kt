package com.sallyjayz.colabsroomaccess.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.sallyjayz.colabsroomaccess.R

/**
 * Created by Salama Jatau on 02-Feb-26.
 */

@Composable
fun EditTextField(
    @StringRes label: Int,
    leadingIcon: ImageVector,
    keyboardOptions: KeyboardOptions,
    input: String,
    updateState: (String) -> Unit,
    validatorHasErrors: Boolean,
    modifier: Modifier = Modifier
) {
    TextField(
        value = input,
        onValueChange = updateState,
        leadingIcon = {
            Icon(imageVector = leadingIcon, contentDescription = null)
        },
        label = {
            Text(stringResource(label))
        },
        singleLine = true,
        keyboardOptions = keyboardOptions,
        isError = validatorHasErrors,
        supportingText = {
            if (validatorHasErrors) {
                Text(stringResource(R.string.incorrect_email_format))
            }
        },
        modifier = modifier
    )
}