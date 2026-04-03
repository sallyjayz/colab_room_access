package com.sallyjayz.colabsroomaccess.navigations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sallyjayz.colabsroomaccess.ui.bookings.BookingsScreen
import com.sallyjayz.colabsroomaccess.ui.explore.ExploreScreen
import com.sallyjayz.colabsroomaccess.ui.home.HomeScreen
import com.sallyjayz.colabsroomaccess.ui.profile.ProfileScreen
import com.sallyjayz.colabsroomaccess.ui.subscription.SubscriptionScreen

/**
 * Created by Salama Jatau on 28-Feb-26.
 */

enum class Destination(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val contentDescription: String
) {
    HOME("home", "Home", Icons.Filled.Home, "Home"),
    BOOKINGS("bookings", "Bookings", Icons.Filled.DateRange, "Bookings"),
    EXPLORE("explore", "Explore", Icons.Filled.Explore, "Explore"),
    SUBSCRIPTION("subscription", "Subscription", Icons.Filled.DateRange, "Subscription"),
    PROFILE("profile", "Profile", Icons.Filled.Person, "Profile")
}


@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: Destination,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController,
        startDestination = startDestination.route,
        modifier = modifier
    ) {
        Destination.entries.forEach { destination ->
            composable(destination.route) {
                when (destination) {
                    Destination.HOME -> HomeScreen()
                    Destination.BOOKINGS -> BookingsScreen()
                    Destination.EXPLORE -> ExploreScreen()
                    Destination.SUBSCRIPTION -> SubscriptionScreen()
                    Destination.PROFILE -> ProfileScreen()
                }
            }
        }
    }
}