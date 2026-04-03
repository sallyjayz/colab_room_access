package com.sallyjayz.colabsroomaccess.ui.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sallyjayz.colabsroomaccess.R

/**
 * Created by Salama Jatau on 12-Mar-26.
 */

@Composable
fun RoomCard(
    imageDescription: String,
    room: String,
    roomType: String,
    availability: String,
    meetingCapacity: String,
    eventCapacity: String
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
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = imageDescription,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()

        )
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(room,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(4.dp)
            )
            Text(roomType,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.tertiaryContainer,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(6.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.tertiaryContainer,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(start = 8.dp, top = 16.dp, bottom = 16.dp, end = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(stringResource(R.string.next_availability), color = Color.Green)
                Spacer(modifier = Modifier.height(8.dp))
                Text(availability, style = MaterialTheme.typography.titleLarge)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .padding(start = 8.dp, top = 16.dp, bottom = 16.dp, end = 8.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(stringResource(R.string.meeting_capacity), style = MaterialTheme.typography.labelLarge)
                    Text(meetingCapacity, style = MaterialTheme.typography.titleMedium)

                }

                VerticalDivider(thickness = 2.dp, modifier = Modifier.fillMaxHeight())

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp)
                ) {
                    Text(stringResource(R.string.event_capacity), style = MaterialTheme.typography.labelLarge)
                    Text(eventCapacity, style = MaterialTheme.typography.titleMedium)
                }
            }
        }
    }

}