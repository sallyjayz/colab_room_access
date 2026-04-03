package com.sallyjayz.colabsroomaccess.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sallyjayz.colabsroomaccess.R
import com.sallyjayz.colabsroomaccess.ui.explore.RoomCard

/**
 * Created by Salama Jatau on 28-Feb-26.
 */

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .padding(
                horizontal = dimensionResource(R.dimen.sixteen)
            )
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(bottom = dimensionResource(R.dimen.sixteen))
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Your image",
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(50.dp)),
                contentScale = ContentScale.Crop,
            )
            Column(modifier = Modifier.padding(start = dimensionResource(R.dimen.eight))) {
                Text(
                    "Welcome Back",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    "Salama Jatau",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary,
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(16.dp)
            ){
                Text("Subscription Usage", style = MaterialTheme.typography.bodyLarge)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text("2h 15m ",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                    )

                    HorizontalDivider(
                        thickness = 2.dp,
                        modifier = Modifier.weight(1f).padding(top = 8.dp)
                    )

                    Text(" Remaining", style = MaterialTheme.typography.bodyLarge)
                }
                Text(
                    "Expires: 24 December 2025",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colorScheme.secondary,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(8.dp)
                        .fillMaxWidth()
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        ) {
            Text("Upcoming Booking", style = MaterialTheme.typography.titleLarge)
            Text(
                "View All",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color=MaterialTheme.colorScheme.error,
                    shape = RoundedCornerShape(
                        topStart = 12.dp,
                        bottomStart = 12.dp,
                        topEnd = 20.dp,
                        bottomEnd = 20.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(2.dp)

            )

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary,
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text("Purple Room",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(bottom = 4.dp))
                    Text("Approved",
                        color = Color.Green,
                        modifier = Modifier
                            .background(
                                color = MaterialTheme.colorScheme.tertiaryContainer,
                                shape = RoundedCornerShape(50.dp)
                            )
                        .padding(8.dp))

                    HorizontalDivider(thickness = 1.dp, modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))

                    Row(
                        modifier = Modifier
                            .height(IntrinsicSize.Min)
                            .padding(top = 8.dp)
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                "Date",
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                "Tomorrow",
                                style = MaterialTheme.typography.titleMedium
                            )
                        }

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                "Time",
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                "10am - 10:30am",
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }
                }
            }

        }


        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        ) {
            Text("Explore Room", style = MaterialTheme.typography.titleLarge)
            Text("View All",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End))
        }

        RoomCard(
            "Room Photo",
            "Room Alpha",
            "Conference",
            "2:00PM - 4:00PM",
            "4 People",
            "24 People",
        )

    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}