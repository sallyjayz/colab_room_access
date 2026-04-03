package com.sallyjayz.colabsroomaccess.ui.explore

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.People
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.AssistChip
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import com.sallyjayz.colabsroomaccess.R
import com.sallyjayz.colabsroomaccess.ui.FilledButton
import com.sallyjayz.colabsroomaccess.ui.explore.carousel.HeroCarousel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.Int

/**
 * Created by Salama Jatau on 12-Mar-26.
 */

data class CarouselItem(
    val id: Int,
    @DrawableRes val imageResId: Int,
    val contentDescription: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreRoomDetailsScreen() {

    val items = remember {
        listOf(
            CarouselItem(0, R.drawable.ic_launcher_background, "cupcake"),
            CarouselItem(1, R.drawable.ic_launcher_background, "donut"),
            CarouselItem(2, R.drawable.ic_launcher_background, "eclair"),
            CarouselItem(3, R.drawable.ic_launcher_background, "froyo"),
            CarouselItem(4, R.drawable.ic_launcher_background, "gingerbread"),
        )
    }

    val scope = rememberCoroutineScope()
    val openAlertDialog = remember { mutableStateOf(false) }
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            initialValue = SheetValue.Hidden,
            skipHiddenState = false // Allow hiding completely
        )
    )

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = 0.dp,
//            sheetShape = ,
        sheetShadowElevation = 8.dp,
        sheetContent = {
            if (openAlertDialog.value) {
                NextSevenDaysAvailabilityContentSheet(
                    openAlertDialog = openAlertDialog,
                    scope = scope,
                    scaffoldState = scaffoldState
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .fillMaxSize()
                .safeDrawingPadding()
        ) {
            HeroCarousel(items)
            RoomCardContent(modifier = Modifier
                .offset(y = (-10).dp),
                openAlertDialog = openAlertDialog,
                scope = scope,
                scaffoldState = scaffoldState
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NextSevenDaysAvailabilityContentSheet(
    openAlertDialog: MutableState<Boolean>,
    scope: CoroutineScope,
    scaffoldState: BottomSheetScaffoldState
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("Next 7-Days Availability")

            IconButton(
                onClick = {
                    openAlertDialog.value = false
                    scope.launch { scaffoldState.bottomSheetState.hide() }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Close,
                    contentDescription = null,
                )


            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        //Availability
        Column(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                    shape = RoundedCornerShape(12.dp)
                )
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text("Today's Availability")
                Text(
                    "Next 7 days availability",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.End)
                )
            }

            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .padding(top = 8.dp)
                    .fillMaxWidth()
            ) {
                Text("10:00am", modifier = Modifier.weight(1f))
                HorizontalDivider(thickness = 2.dp, modifier = Modifier
                    .padding(top = 12.dp)
                    .weight(2f))
                Text(
                    "12:30pm",
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth(Alignment.End)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .padding(top = 8.dp)
                    .fillMaxWidth()
            ) {
                Text("2:30pm", modifier = Modifier.weight(1f))
                HorizontalDivider(thickness = 2.dp, modifier = Modifier
                    .padding(top = 12.dp)
                    .weight(2f))
                Text(
                    "6:00pm",
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth(Alignment.End)
                )
            }

        } //End of Availability

        Spacer(modifier = Modifier.height(8.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RoomCardContent(
    modifier: Modifier = Modifier,
    openAlertDialog: MutableState<Boolean>,
    scope: CoroutineScope,
    scaffoldState: BottomSheetScaffoldState
) {

    var chipSelected by remember { mutableStateOf(false) }
    val amenitiesStatus =
        listOf(
            "AC",
            "TV",
            "Projector",
        )

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .background(
                    color=MaterialTheme.colorScheme.onPrimary,
                    shape = RoundedCornerShape(
                        topStart = 25.dp,
                        bottomStart = 0.dp,
                        topEnd = 25.dp,
                        bottomEnd = 0.dp)
                )
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text("Yellow Room",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(4.dp)
            )

            Text("Conference",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.tertiaryContainer,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(6.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            //Capacity
            Column(
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.tertiaryContainer,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text("Capacity", style = MaterialTheme.typography.labelLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("For Meeting", style = MaterialTheme.typography.labelLarge)
                        Row {
                            Icon(
                                imageVector = Icons.Outlined.Person,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(20.dp)
                                    .padding(
                                        top = dimensionResource(R.dimen.four),
                                        end = dimensionResource(R.dimen.eight)
                                    )
                            )

                            Text("6", style = MaterialTheme.typography.titleMedium)
                        }
                    }

                    VerticalDivider(thickness = 2.dp, modifier = Modifier.fillMaxHeight())

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 16.dp)
                    ) {
                        Text("For Event", style = MaterialTheme.typography.labelLarge)

                        Row {
                            Icon(
                                imageVector = Icons.Outlined.People,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(20.dp)
                                    .padding(
                                        top = dimensionResource(R.dimen.four),
                                        end = dimensionResource(R.dimen.eight)
                                    )
                            )
                            Text("40", style = MaterialTheme.typography.titleMedium)
                        }

                    }
                }
            }//end of capacity

            Spacer(modifier = Modifier.height(8.dp))

            //Availability
            Column(
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.tertiaryContainer,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text("Today's Availability")
                    Text(
                        "Next 7 days availability",
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End)
                    )
                }

                Row(
                    modifier = Modifier
                        .height(IntrinsicSize.Min)
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                ) {
                    Text("10:00am", modifier = Modifier.weight(1f))
                    HorizontalDivider(thickness = 2.dp, modifier = Modifier
                        .padding(top = 12.dp)
                        .weight(2f))
                    Text(
                        "12:30pm",
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End)

                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier
                        .height(IntrinsicSize.Min)
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                ) {
                    Text("2:30pm", modifier = Modifier.weight(1f))
                    HorizontalDivider(thickness = 2.dp, modifier = Modifier
                        .padding(top = 12.dp)
                        .weight(2f))
                    Text(
                        "6:00pm",
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End)
                    )
                }


            } //End of Availability

            //Amenities
            Column(
                modifier = Modifier.padding(top = 8.dp)
            ){
                Text("Amenities",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                FlowRow(
                    modifier =
                        Modifier
                            .fillMaxWidth(1f)
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
                            Modifier
                                .padding(horizontal = 4.dp)
                                .align(alignment = Alignment.CenterVertically),
                        onClick = { chipSelected = !chipSelected },
                        label = { Text("Wifi", style = MaterialTheme.typography.bodySmall) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Wifi,
                                contentDescription = "Localized Description",
                                modifier = Modifier.size(FilterChipDefaults.IconSize),
                            )
                        },
                    )
                    Box(
                        Modifier
                            .height(FilterChipDefaults.Height)
                            .align(alignment = Alignment.CenterVertically)
                    ) {
//                    VerticalDivider()
                    }
                    amenitiesStatus.fastForEachIndexed { index, element ->
                        AssistChip(
                            modifier =
                                Modifier
                                    .padding(horizontal = 4.dp)
                                    .align(alignment = Alignment.CenterVertically),
                            onClick = { /* do something*/ },
                            label = { Text(element, style = MaterialTheme.typography.bodySmall) },
//                        label = { Text("$element $index") },
                        )
                    }
                }

            }//Amenities end

            Spacer(modifier = Modifier.height(8.dp))

            //Description
            Column(
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.tertiaryContainer,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    "Description",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .padding(8.dp))

                HorizontalDivider(modifier = Modifier.padding(start = 8.dp, end = 8.dp))

                Text("The Yellow Room is a vibrant conference" +
                        "\n space, equipped with modern amenities and" +
                        "\n ample seating for productive meetings and" +
                        "\n collaborative events.",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(dimensionResource(R.dimen.eight))
                        .fillMaxWidth()
                )
            }//Description end

            Spacer(modifier = Modifier.height(8.dp))

            //Room Rules
            Column(
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.tertiaryContainer,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    "Room Rules",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .padding(8.dp))

                HorizontalDivider(modifier = Modifier.padding(start = 8.dp, end = 8.dp))

                Text("1. Keep the space tidy. " +
                        "\n2. Be respectful of others. " +
                        "\n3. No loud music. " +
                        "\n4. Clean up after use. " +
                        "\n5. Report any damages.",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(dimensionResource(R.dimen.eight))
                        .fillMaxWidth()
                )
            }//Room rules end

            Spacer(modifier = Modifier.height(8.dp))

            //Book now button
            FilledButton(
                onClick = {
                    openAlertDialog.value = true
                    scope.launch { scaffoldState.bottomSheetState.expand() }
                },
                buttonText = R.string.book_now,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) //end of book now button
        }
    }
}


