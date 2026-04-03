package com.sallyjayz.colabsroomaccess.ui.explore

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import com.sallyjayz.colabsroomaccess.R
import com.sallyjayz.colabsroomaccess.ui.explore.search.SearchBarWidget

/**
 * Created by Salama Jatau on 28-Feb-26.
 */

@Composable
fun ExploreScreen() {

    //search
    var query by rememberSaveable { mutableStateOf("") }
    val items= listOf<String>(
        /*"Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb",
        "Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow",
        "Nougat", "Oreo", "Pie"*/
    )

    // Filter items based on query
    val filteredItems by remember {
        derivedStateOf {
            if (query.isEmpty()) {
                items
            } else {
                items.filter { it.contains(query, ignoreCase = true) }
            }
        }
    }


    //filterchip
    var chipSelected by remember { mutableStateOf(false) }
    val exploreRoomFilter =
        listOf(
            "Available",
            "Conference Room",
            "Meeting Room",
        )

    Column(
        modifier = Modifier
            .padding(
                horizontal = dimensionResource(R.dimen.sixteen)
            )
            .fillMaxSize()
    ) {

        //title
        Text("Explore Rooms",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.ExtraBold, color = MaterialTheme.colorScheme.primary)


        //search
        SearchBarWidget(
            query = query,
            onQueryChange = { query = it },
            onSearch = { /* Handle search submission */ },
            searchResults = filteredItems,
            onResultClick = { query = it },
            // Customize appearance with optional parameters
            placeholder = { Text("Search desserts") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
//            trailingIcon = { Icon(Icons.Default.MoreVert, contentDescription = "More options") },
            supportingContent = { Text("Android dessert") },
            leadingContent = { Icon(Icons.Filled.Star, contentDescription = "Starred item") },
        )

        // Display the filtered list below the search bar
        LazyColumn(
            contentPadding = PaddingValues(
//                start = 16.dp,
//                top = 16.dp, // Provides space for the search bar
//                end = 16.dp,
//                bottom = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.semantics {
                traversalIndex = 1f
            },
        ) {
            /*items(count = filteredItems.size) {
                Text(text = filteredItems[it])
            }*/
        }



        //filterchip
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
            exploreRoomFilter.fastForEachIndexed { index, element ->
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


        Column(
            modifier = Modifier
//                .padding(bottom = dimensionResource(R.dimen.sixteen))
                .verticalScroll(rememberScrollState())
        ) {


            //roomCard
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

}


@Preview(showBackground = true)
@Composable
fun ExploreScreenPreview() {
    ExploreScreen()
}
