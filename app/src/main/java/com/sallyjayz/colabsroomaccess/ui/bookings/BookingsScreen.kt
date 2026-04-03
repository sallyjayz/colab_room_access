package com.sallyjayz.colabsroomaccess.ui.bookings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.input.setTextAndPlaceCursorAtEnd
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastForEachIndexed
import com.sallyjayz.colabsroomaccess.R

/**
 * Created by Salama Jatau on 28-Feb-26.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingsScreen() {

//    var expanded by remember { mutableStateOf(false) }
    val options = listOf("This Month", "Last Month", "Next Month")
    var selectedOptionText by remember { mutableStateOf(options[0]) }

    var chipSelected by remember { mutableStateOf(false) }
    val bookingHistoryStatus =
        listOf(
            "Completed",
            "Cancelled",
            "Declined",
            "Missed",
            "Pending",
            "Approved",
        )


    Column(
        modifier = Modifier
            .padding(
                horizontal = dimensionResource(R.dimen.sixteen)
            )
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {
        //title and description
        Column(
            modifier = Modifier
                .padding(bottom = dimensionResource(R.dimen.sixteen))
        ) {
            Text("My Bookings", 
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.ExtraBold, color = MaterialTheme.colorScheme.primary)
            Text("View and manage all your room bookings", style = MaterialTheme.typography.bodyMedium)
        }

        //overview card
        Card(
            modifier = Modifier.fillMaxWidth().padding(bottom = dimensionResource(R.dimen.sixteen)),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onPrimary,
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text("Overview", style = MaterialTheme.typography.bodyLarge)

                    Spacer(modifier = Modifier.weight(1f))

                    WrapContentDropdown(
                        options = options,
                        selected = selectedOptionText,
                        onSelected = { selectedOptionText = it }
                    )
                }

                Row(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .height(IntrinsicSize.Min)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .border(border = BorderStroke(width = 1.dp,
                                color = Color.LightGray),
                                shape = RoundedCornerShape(8.dp)
                            )
                    ) {
                        Text("Total Bookings", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(start = 8.dp, top = 8.dp))
                        Text("8", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(start = 8.dp, top = 4.dp, bottom = 8.dp))
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .border(border = BorderStroke(width = 1.dp,
                                color = Color.LightGray),
                                shape = RoundedCornerShape(8.dp)
                            )
                    ) {
                        Text("Upcoming", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(start = 8.dp, top = 8.dp))
                        Text("3", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(start = 8.dp, top = 4.dp, bottom = 8.dp))
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier
                        .height(IntrinsicSize.Min)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .border(border = BorderStroke(width = 1.dp,
                                color = Color.LightGray),
                                shape = RoundedCornerShape(8.dp)
                            )
                    ) {
                        Text("Completed", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(start = 8.dp, top = 8.dp))
                        Text("1", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(start = 8.dp, top = 4.dp, bottom = 8.dp))
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .border(border = BorderStroke(width = 1.dp,
                                color = Color.LightGray),
                                shape = RoundedCornerShape(8.dp)
                            )
                    ) {
                        Text("Failed", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(start = 8.dp, top = 8.dp))
                        Text("1", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(start = 8.dp, top = 4.dp, bottom = 8.dp))
                    }
                }
            }
        }

        //upcoming booking
        Column(
            modifier = Modifier.padding(bottom = 16.dp)
        ) {

            Text("Upcoming Booking",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .fillMaxWidth()
            ) {
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

                        Row(
                            modifier = Modifier
                                .height(IntrinsicSize.Min)
                                .padding(top = 8.dp)
                                .fillMaxWidth()
                        ){
                            Column(
                                modifier = Modifier.weight(1.5f)
                            ) {
                                Text("Date",
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                Text("Tomorrow",
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }

                            Column(
                                modifier = Modifier.weight(2f)
                            ) {
                                Text("Time",
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                Text("10am - 10:30am",
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }

                            Column(
                                modifier = Modifier
                                    .weight(1f)
                            ) {
                                Text("Reason",
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                Text("Meeting",
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }
                        }

                    }
                }
            }
        }

        //bookings history
        Column(
            modifier = Modifier.padding(bottom = 16.dp)
        ){
            Text("Bookings History",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            //booking history filterchip
            FlowRow(
                modifier =
                    Modifier.fillMaxWidth(1f)
                        .wrapContentHeight(align = Alignment.Top)
                        .then(
                            if (chipSelected) {
                                Modifier.verticalScroll(rememberScrollState())
                            } else {
                                Modifier.horizontalScroll(rememberScrollState())
                            }
                        ),
                horizontalArrangement = Arrangement.Start,
                maxLines = if (!chipSelected) 1 else Int.MAX_VALUE,
            ) {
                /*
                 * When chip lists exceed the available horizontal screen space, one option is to
                 * provide a leading chip that expands the list into a vertical scrolling list. This
                 * ensures all options are accessible while maintaining the position of the content
                 * below the chip list.
                 */
                FilterChip(
                    selected = chipSelected,
                    modifier =
                        Modifier.padding(horizontal = 4.dp)
                            .align(alignment = Alignment.CenterVertically),
                    onClick = { chipSelected = !chipSelected },
                    label = { Text("All", style = MaterialTheme.typography.bodySmall) },
//                    leadingIcon = {
//                        Icon(
//                            imageVector = Icons.Filled.Tune,
//                            contentDescription = "Localized Description",
//                            modifier = Modifier.size(FilterChipDefaults.IconSize),
//                        )
//                    },
                )
                Box(
                    Modifier.height(FilterChipDefaults.Height)
                        .align(alignment = Alignment.CenterVertically)
                ) {
//                    VerticalDivider()
                }
                bookingHistoryStatus.fastForEachIndexed { index, element ->
                    AssistChip(
                        modifier =
                            Modifier.padding(horizontal = 4.dp)
                                .align(alignment = Alignment.CenterVertically),
                        onClick = { /* do something*/ },
                        label = { Text(element, style = MaterialTheme.typography.bodySmall) },
//                        label = { Text("$element $index") },
                    )
                }
            }

            //booking history card

            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .fillMaxWidth()
            ) {
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
                        Text("Room Alpha",
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(bottom = 4.dp))
                        Text("Conference Room",
                            modifier = Modifier
                                .background(
                                    color = MaterialTheme.colorScheme.tertiaryContainer,
                                    shape = RoundedCornerShape(50.dp)
                                )
                                .padding(8.dp))

                        HorizontalDivider(thickness = 1.dp, modifier = Modifier.padding(top = 16.dp, bottom = 8.dp))

                        Row(
                            modifier = Modifier
                                .height(IntrinsicSize.Min)
                                .padding(top = 8.dp)
                                .fillMaxWidth()
                        ){
                            Column(
                                modifier = Modifier.weight(1.5f)
                            ) {
                                Text("Date",
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                Text("Tomorrow",
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }

                            Column(
                                modifier = Modifier.weight(2f)
                            ) {
                                Text("Time",
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                Text("10am - 10:30am",
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }

                            Column(
                                modifier = Modifier
                                    .weight(1f)
                            ) {
                                Text("Reason",
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                Text("Meeting",
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }
                        }
                        Text("Cancelled",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(top = 8.dp))
                    }
                }
            }
        }
    }
}

/*Generic way of implementation
* fun <T> WrapContentDropdown(
    options: List<T>,
    selected: T,
    label: (T) -> String,
    onSelected: (T) -> Unit
)
* */

@Composable
fun WrapContentDropdown(
    options: List<String>,
    selected: String,
    onSelected: (String) -> Unit
) {

    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.wrapContentSize()
    ) {

        Row(
            modifier = Modifier
                .clickable { expanded = !expanded  }
                .background(color = MaterialTheme.colorScheme.tertiaryContainer,
                    shape = RoundedCornerShape(50.dp))
                /*.border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(50.dp)
                )*/
                .padding(horizontal = 10.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = selected,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1
            )

            Spacer(Modifier.width(4.dp))

            Icon(
                imageVector = if (expanded)
                    Icons.Filled.KeyboardArrowUp
                else
                    Icons.Filled.KeyboardArrowDown,
                contentDescription = null
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {

            options.forEach { option ->

                DropdownMenuItem(
                    text = { Text(option, style = MaterialTheme.typography.bodyMedium) },
                    onClick = {
                        onSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookingsScreenPreview() {
    BookingsScreen()
}