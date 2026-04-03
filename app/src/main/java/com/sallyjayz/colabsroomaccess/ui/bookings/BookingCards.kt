package com.sallyjayz.colabsroomaccess.ui.bookings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sallyjayz.colabsroomaccess.R

/**
 * Created by Salama Jatau on 11-Mar-26.
 */

@Composable
fun BookingStatusCard(
    room: String,
    status: String,
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        Column(modifier = Modifier.padding(start = 8.dp, top = 8.dp, bottom = 16.dp)){
            Text(room,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 4.dp))
            Text(status,
                color = Color.Green,
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.tertiaryContainer,
                        shape = RoundedCornerShape(50.dp)
                    )
                    .padding(8.dp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = room,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()

        )
    }
}


@Composable
fun BookingSummaryCard(
    status: String,
    date: String,
    startTime: String,
    duration: String,
    roomType: String,
    bookingReason: String,
    bookingId: String,
) {
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
            stringResource(R.string.summary),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(8.dp)
        )

        Column(
            modifier = Modifier
                .padding(
                    horizontal = dimensionResource(R.dimen.sixteen)
                )
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(12.dp)
                )
        ) {

            Row(modifier = Modifier.padding(8.dp)) {
                Text(stringResource(R.string.status), style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.weight(1f))
                Text(status,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            HorizontalDivider(modifier = Modifier.padding(start = 8.dp, end = 8.dp))

            Row(modifier = Modifier.padding(8.dp)) {
                Text(stringResource(R.string.date), style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.weight(1f))
                Text(date, style = MaterialTheme.typography.bodyMedium)
            }

            HorizontalDivider(modifier = Modifier.padding(start = 8.dp, end = 8.dp))

            Row(modifier = Modifier.padding(8.dp)) {
                Text(stringResource(R.string.start_time), style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.weight(1f))
                Text(startTime, style = MaterialTheme.typography.bodyMedium)
            }

            HorizontalDivider(modifier = Modifier.padding(start = 8.dp, end = 8.dp))

            Row(modifier = Modifier.padding(8.dp)) {
                Text(stringResource(R.string.duration), style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.weight(1f))
                Text(duration, style = MaterialTheme.typography.bodyMedium)
            }
        }

        Column(
            modifier = Modifier
                .padding(
                    horizontal = dimensionResource(R.dimen.sixteen),
                    vertical = dimensionResource(R.dimen.sixteen)
                )
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(12.dp)
                )
        ) {
            Row(modifier = Modifier.padding(8.dp)) {
                Text(stringResource(R.string.room_type), style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.weight(1f))
                Text(roomType, style = MaterialTheme.typography.bodyMedium)
            }

            HorizontalDivider(modifier = Modifier.padding(start = 8.dp, end = 8.dp))

            Row(modifier = Modifier.padding(8.dp)) {
                Text(stringResource(R.string.booking_reason), style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.weight(1f))
                Text(bookingReason, style = MaterialTheme.typography.bodyMedium)
            }

            HorizontalDivider(modifier = Modifier.padding(start = 8.dp, end = 8.dp))

            Row(modifier = Modifier.padding(8.dp)) {
                Text(stringResource(R.string.booking_id), style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.weight(1f))
                Text(bookingId, style = MaterialTheme.typography.bodyMedium)
            }

        }
    }

}

@Composable
fun BookingHistorySummaryCard(
    status: String,
    date: String,
    bookingReason: String,
    startTime: String,
    endTime: String,
    duration: String,
    roomType: String,
    bookingId: String,
) {
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
            stringResource(R.string.summary),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(8.dp)
        )

        Column(
            modifier = Modifier
                .padding(
                    horizontal = dimensionResource(R.dimen.sixteen)
                )
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(12.dp)
                )
        ) {

            Row(modifier = Modifier.padding(8.dp)) {
                Text(stringResource(R.string.status), style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.weight(1f))
                Text(status,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            HorizontalDivider(modifier = Modifier.padding(start = 8.dp, end = 8.dp))

            Row(modifier = Modifier.padding(8.dp)) {
                Text(stringResource(R.string.date), style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.weight(1f))
                Text(date, style = MaterialTheme.typography.bodyMedium)
            }

            HorizontalDivider(modifier = Modifier.padding(start = 8.dp, end = 8.dp))

            Row(modifier = Modifier.padding(8.dp)) {
                Text(stringResource(R.string.booking_reason), style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.weight(1f))
                Text(bookingReason, style = MaterialTheme.typography.bodyMedium)
            }

            HorizontalDivider(modifier = Modifier.padding(start = 8.dp, end = 8.dp))

            Row(modifier = Modifier.padding(8.dp)) {
                Text(stringResource(R.string.start_time), style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.weight(1f))
                Text(startTime, style = MaterialTheme.typography.bodyMedium)
            }

            HorizontalDivider(modifier = Modifier.padding(start = 8.dp, end = 8.dp))

            Row(modifier = Modifier.padding(8.dp)) {
                Text(stringResource(R.string.end_time), style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.weight(1f))
                Text(endTime, style = MaterialTheme.typography.bodyMedium)
            }

            HorizontalDivider(modifier = Modifier.padding(start = 8.dp, end = 8.dp))

            Row(modifier = Modifier.padding(8.dp)) {
                Text(stringResource(R.string.duration), style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.weight(1f))
                Text(duration, style = MaterialTheme.typography.bodyMedium)
            }
        }

        Column(
            modifier = Modifier
                .padding(
                    horizontal = dimensionResource(R.dimen.sixteen),
                    vertical = dimensionResource(R.dimen.sixteen)
                )
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(12.dp)
                )
        ) {
            Row(modifier = Modifier.padding(8.dp)) {
                Text(stringResource(R.string.room_type), style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.weight(1f))
                Text(roomType, style = MaterialTheme.typography.bodyMedium)
            }

            HorizontalDivider(modifier = Modifier.padding(start = 8.dp, end = 8.dp))

            Row(modifier = Modifier.padding(8.dp)) {
                Text(stringResource(R.string.booking_id), style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.weight(1f))
                Text(bookingId, style = MaterialTheme.typography.bodyMedium)
            }

        }
    }

}

@Composable
fun NoteAddedCard(
    note: String
) {
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
            stringResource(R.string.note_added),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(8.dp))

        HorizontalDivider(modifier = Modifier.padding(start = 8.dp, end = 8.dp))

        Text(note,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(dimensionResource(R.dimen.eight))
                .fillMaxWidth()
        )
    }
}

@Composable
fun BookingTimelineCard(
    timeline: String
) {

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
            stringResource(R.string.booking_timeline),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(8.dp))
        Column(
            modifier = Modifier
                .padding(
                    dimensionResource(R.dimen.sixteen)
                )
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(12.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(50.dp)),
                    contentScale = ContentScale.Crop,
                )
                Column(modifier = Modifier.padding(start = dimensionResource(R.dimen.eight))) {
                    Text(
                        "Booked on",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Blue,
                        modifier = Modifier
                            .background(
                                color = MaterialTheme.colorScheme.tertiaryContainer,
                                shape = RoundedCornerShape(50.dp)
                            )
                    )
                    Text(
                        timeline,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}