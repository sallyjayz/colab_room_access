package com.sallyjayz.colabsroomaccess.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

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

@Composable
fun ElevateButton(
    onClick: () -> Unit,
    @DrawableRes
    icon: Int,
    description: String,
    @StringRes buttonText: Int,
    modifier: Modifier = Modifier
) {
    ElevatedButton(onClick = onClick, modifier = modifier) {

        Icon(
            painter = painterResource(icon),
            contentDescription = description,
            modifier = Modifier.padding(end = 4.dp).size(20.dp)
        )

        Text(
            text = stringResource(buttonText),
            textAlign = TextAlign.Center
        )
    }
}