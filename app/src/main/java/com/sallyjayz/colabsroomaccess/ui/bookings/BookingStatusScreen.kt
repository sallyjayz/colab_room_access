package com.sallyjayz.colabsroomaccess.ui.bookings

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sallyjayz.colabsroomaccess.R
import com.sallyjayz.colabsroomaccess.ui.ElevateButton
import com.sallyjayz.colabsroomaccess.ui.FilledButton
import com.sallyjayz.colabsroomaccess.ui.bookings.dialog.CancelBookingDialog

/**
 * Created by Salama Jatau on 06-Mar-26.
 */

@Composable
fun BookingStatusScreen() {

    val openAlertDialog = remember { mutableStateOf(false) }

    if (openAlertDialog.value) {
        CancelBookingDialog(openAlertDialog = openAlertDialog)
    }

    Column (
        modifier = Modifier
            .padding(
                horizontal = dimensionResource(R.dimen.sixteen)
            )
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),

    ) {
        //booking status
        BookingStatusCard(
            "Purple Room",
            "Upcoming"
        )
        //end of booking status

        //summary
        BookingSummaryCard(
            "Approved",
            "Today",
            "10:00AM",
            "30 Minutes",
            "Conference Room",
            "Interview",
            "#B101-0001"
        )
        // end of summary

        //Access key
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onPrimary,
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        ) {
            Text(
                stringResource(R.string.access_key),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(8.dp)
            )

            Column(
                modifier = Modifier
                    .padding(
                        start = dimensionResource(R.dimen.sixteen),
                        end = dimensionResource(R.dimen.sixteen),
                        bottom = dimensionResource(R.dimen.sixteen)
                    )
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .fillMaxWidth()
            ) {
                Text("103 - 102",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )


                Row(
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colorScheme.tertiaryContainer,
                            shape = RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp)
                        )
                        .padding(dimensionResource(R.dimen.eight))
                        .fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(R.drawable.password_instruction_logo),
                        contentDescription = null,
                        modifier = Modifier.padding(top = dimensionResource(R.dimen.four), end = dimensionResource(R.dimen.eight))
                    )

                    Text(
                        stringResource(R.string.access_key_instruction) +
                            "booking time to access the room",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }//end of access key

        //Hour usage
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onPrimary,
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        ) {
            Text(stringResource(R.string.hour_usage),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(8.dp)
            )

            Row(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
                    .height(IntrinsicSize.Min)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .background(
                            color = MaterialTheme.colorScheme.tertiaryContainer,
                            shape = RoundedCornerShape(12.dp)
                        )
                ) {
                    Text(stringResource(R.string.available_hour), style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(start = 8.dp, top = 8.dp))
                    Text("1h 30m", fontWeight = FontWeight.SemiBold, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(start = 8.dp, top = 4.dp, bottom = 8.dp))
                }

                Spacer(modifier = Modifier.width(8.dp))

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom = 8.dp)
                        .background(
                            color = MaterialTheme.colorScheme.tertiaryContainer,
                            shape = RoundedCornerShape(12.dp)
                        )
                ) {
                    Text(stringResource(R.string.hours_deducted), style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(start = 8.dp, top = 8.dp))
                    Text("0h 30m", fontWeight = FontWeight.SemiBold, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(start = 8.dp, top = 4.dp, bottom = 8.dp))
                }
            }
        } //end of hour usage

        //Note Added
        NoteAddedCard(
            "The Yellow Room is a vibrant conference \n space, " +
                    "equipped with modern amenities and \n ample seating for " +
                    "productive meetings and \n collaborative events."
        )
        //end of note added

        //Booking timeline
        BookingTimelineCard(
            "Dec 10, 2025 - 3:45 PM"
        )
        // end of booking timeline

        //Add calendar

        ElevateButton(
            onClick = {},
            icon = R.drawable.ic_launcher_background,
            description = stringResource(R.string.add_to_calendar),
            buttonText = R.string.add_to_calendar,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .wrapContentSize()
        ) //end of calendar

        //cancel button
        FilledButton(
            onClick = {
                openAlertDialog.value = true
            },
            buttonText = R.string.cancel_booking,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) //end of cancel button


    }//end of parent column

} //end of upcoming booking screen


@Preview(
    showBackground = true,
    widthDp = 360,
    heightDp = 1500
)
@Composable
fun BookingStatusScreenPreview() {
    BookingStatusScreen()
}