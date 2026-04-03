package com.sallyjayz.colabsroomaccess.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.sallyjayz.colabsroomaccess.R
import com.sallyjayz.colabsroomaccess.navigations.AppNavHost
import com.sallyjayz.colabsroomaccess.navigations.Destination

/**
 * Created by Salama Jatau on 19-Feb-26.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBottomBar(modifier: Modifier = Modifier) {

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    val navController = rememberNavController()
    val startDestination = Destination.HOME
    var selectedDestination by rememberSaveable { mutableIntStateOf(startDestination.ordinal) }

    var itemCount by remember { mutableIntStateOf(3) }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary
                ),
                title = {
                    Image(
                        painter = painterResource(R.drawable.colab_logo),
                        contentDescription = null
                    )
                },
                actions = {
                    BadgedBox(
                        badge = {
                            if (itemCount > 0) {
                                Badge(
                                    containerColor = MaterialTheme.colorScheme.error,
                                    contentColor = MaterialTheme.colorScheme.onError,
                                    modifier = Modifier.offset(x = (-10).dp, y = (10).dp)
                                ) {
                                    Text("$itemCount")
                                }
                            }
                        }
                    ) {
                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                imageVector = Icons.Filled.Notifications,
                                contentDescription = stringResource(R.string.notification)
                            )
                        }
                    }
                },
                scrollBehavior = scrollBehavior,

            )
        },

        bottomBar = {
            NavigationBar(
                windowInsets = NavigationBarDefaults.windowInsets,
                containerColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Destination.entries.forEachIndexed { index, destination ->
                    NavigationBarItem(
                        selected = selectedDestination == index,
                        onClick = {
                            navController.navigate(route = destination.route)
                            selectedDestination = index
                        },
                        icon = {
                            Icon(
                                destination.icon,
                                contentDescription = destination.contentDescription
                            )
                        },
                        label = {
                            Text(
                                destination.label,
                                style = MaterialTheme.typography.labelSmall,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold
                                /*color = if (index == selectedDestination)
                                    MaterialTheme.colorScheme.primary
                                else
                                    MaterialTheme.colorScheme.secondary*/
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            indicatorColor = MaterialTheme.colorScheme.onPrimary ,
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        AppNavHost(navController, startDestination, modifier = Modifier.padding(innerPadding))
    }
}


@Preview
@Composable
fun TopBottomBarPreview() {
    TopBottomBar()
}