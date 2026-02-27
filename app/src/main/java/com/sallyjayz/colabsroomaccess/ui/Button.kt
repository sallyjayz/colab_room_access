package com.sallyjayz.colabsroomaccess.ui

import androidx.annotation.StringRes
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign

/**
 * Created by Salama Jatau on 02-Feb-26.
 */

@Composable
fun FilledButton(
    onClick: () -> Unit,
    @StringRes buttonText: Int,
    modifier: Modifier = Modifier
) {
    Button(onClick = onClick) {
        Text(
            text = stringResource(buttonText),
            textAlign = TextAlign.Center,
            modifier = modifier
        )
    }
}