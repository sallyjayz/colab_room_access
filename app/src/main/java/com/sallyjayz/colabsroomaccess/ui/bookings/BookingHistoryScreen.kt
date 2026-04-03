package com.sallyjayz.colabsroomaccess.ui.bookings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sallyjayz.colabsroomaccess.R
import com.sallyjayz.colabsroomaccess.ui.FilledButton

/**
 * Created by Salama Jatau on 11-Mar-26.
 */

@Composable
fun BookingHistoryScreen() {

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
            "Room Alpha",
            "Completed"
        )
        //end of booking status

        //summary
        BookingHistorySummaryCard(
            "Completed",
            "Mon 12 Nov, 2025",
            "Interview",
            "10:00AM",
            "10:30AM",
            "30 Minutes",
            "Conference Room",
            "#B101-0001"
        )
        // end of summary

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
            Text(
                stringResource(R.string.hour_usage),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(8.dp)
            )

            Column(modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
                .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
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
                        Text("Before Session", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(start = 8.dp, top = 8.dp))
                        Text("1h 30m", fontWeight = FontWeight.SemiBold, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(start = 8.dp, top = 4.dp, bottom = 8.dp))
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(bottom = 4.dp)
                            .background(
                                color = MaterialTheme.colorScheme.tertiaryContainer,
                                shape = RoundedCornerShape(12.dp)
                            )
                    ) {
                        Text(stringResource(R.string.hours_deducted), style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(start = 8.dp, top = 8.dp))
                        Text("0h 30m", fontWeight = FontWeight.SemiBold, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(start = 8.dp, top = 4.dp, bottom = 8.dp))
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))

                Column (
                    modifier = Modifier
                        .background(
                            color = Color.Gray,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .fillMaxWidth()
                ) {
                    Text(stringResource(R.string.remaining_after_session), style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(start = 8.dp, top = 8.dp))
                    Text("1h 0m", fontWeight = FontWeight.SemiBold, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(start = 8.dp, top = 4.dp, bottom = 8.dp))
                }
            }




        } //end of hour usage

        //Booking timeline
        BookingTimelineCard(
            "Dec 10, 2025 - 3:45 PM"
        )
        // end of booking timeline

        //Note Added
        NoteAddedCard(
            "The Yellow Room is a vibrant conference \n space, " +
                    "equipped with modern amenities and \n ample seating for " +
                    "productive meetings and \n collaborative events."
        )
        //end of note added

        //book again button
        FilledButton(
            onClick = {},
            buttonText = R.string.book_again,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) //end of book again button

    }

}

@Preview(
    showBackground = true,
    widthDp = 360,
    heightDp = 1500
)
@Composable
fun BookingHistoryScreenPreview() {
    BookingHistoryScreen()
}