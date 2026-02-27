package com.sallyjayz.colabsroomaccess.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import com.sallyjayz.colabsroomaccess.R

/**
 * Created by Salama Jatau on 02-Feb-26.
 */
@Composable
fun EditPasswordTextField(
    @StringRes label: Int,
    leadingIcon: ImageVector,
    input: String,
    updateState: (String) -> Unit,
    trailingIcon: ImageVector,
    onClick: () -> Unit,
    contentDescription: String,
    visualTransformation: VisualTransformation,
    keyboardOptions: KeyboardOptions,
    validatorHasErrors: Boolean,
    modifier: Modifier = Modifier
) {
    TextField(
        value = input,
        onValueChange = updateState,
        leadingIcon = {
            Icon(imageVector = leadingIcon, contentDescription = null)
        },
        trailingIcon = {
            IconButton(onClick = onClick) {
                Icon(
                    imageVector = trailingIcon,
                    contentDescription = contentDescription
                )
            }
        },
        label = {
            Text(stringResource(label))
        },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        singleLine = true,
        isError = validatorHasErrors,
        supportingText = {
            if (validatorHasErrors) {
                Text(stringResource(R.string.incorrect_password))
            }
        },
        modifier = modifier
    )

}