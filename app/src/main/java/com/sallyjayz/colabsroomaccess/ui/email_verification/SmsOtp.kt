package com.sallyjayz.colabsroomaccess.ui.email_verification

import android.view.KeyEvent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly

/**
 * Created by Salama Jatau on 05-Feb-26.
 */
@Composable
fun OTPInputField(
    number: Int?, // allows text field to represent empty state or single digit(0-9)
    focusRequester: FocusRequester, // it allows pragmatically to move from one box to another
    onFocusChanged: (Boolean) -> Unit, // reports whether this specific field is currently active or not
    onNumberChanged: (Int?) -> Unit, // the primary callback when the user types a digit or deletes one
    onKeyboardBack: () -> Unit, // a event to handle `backspace` key when the field is already empty
    modifier: Modifier = Modifier
) {

    var text by remember(number) {
        mutableStateOf(
            // instead of simple String it uses TextFieldValue to control the cursor
            TextFieldValue(
                text = number?.toString().orEmpty(), // if null value use empty text
                selection = TextRange(
                    index = if (number != null) 1 else 0
                ) // index to `1` ensures the cursor is always positioned after the digit
            )
        )
    }

    var isFocused by remember { // initially as false
        mutableStateOf(false)
    }

    Box(
        modifier = modifier
            .border(
                width = 1.dp,
                color = Green
            )
            .background(White),
        contentAlignment = Alignment.Center
    ) {

        BasicTextField(
            value = text,
            onValueChange = { newText ->
                val newNumber = newText.text
                if (newNumber.length <= 1 && newNumber.isDigitsOnly()) {
                    onNumberChanged(newNumber.toIntOrNull())
                } // this ensures the user cannot type more than one character or enter letters/symbols
            },
            cursorBrush = SolidColor(Gray),
            singleLine = true,
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Black
            ),
            keyboardOptions = KeyboardOptions( // keyboard type as number
                keyboardType = KeyboardType.NumberPassword
            ),
            modifier = Modifier
                .padding(10.dp)
                .focusRequester(focusRequester)
                .onFocusChanged {
                    isFocused = it.isFocused
                    onFocusChanged(it.isFocused)
                } // it links the external focusRequester to the internal text field and updates a local isFocused state to handle visual changes
                .onKeyEvent { event ->
                    // if a user hits backspace and the box is already empty,
                    // onKeyboardBack() is triggered.
                    // The parent would then typically use this to move the focus to the previous box,
                    // allowing the user to correct mistakes quickly.
                    val didPressedDelete = event.nativeKeyEvent.keyCode == KeyEvent.KEYCODE_DEL
                    if (didPressedDelete && number == null) {
                        onKeyboardBack()
                    }
                    false
                },
            decorationBox = { innerBox ->
                innerBox()
                if (!isFocused && number == null) {
                    // When the field is empty and not being interacted with,
                    // it displays a -(hyphen).
                    // This provides a visual cue to the user that a digit is missing in that specific slot.
                    Text(
                        text = "-",
                        textAlign = TextAlign.Center,
                        color = Gray,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize()
                    )
                }
            }
        )

    }

}