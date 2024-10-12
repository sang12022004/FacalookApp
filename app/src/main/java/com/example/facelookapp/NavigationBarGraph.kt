package com.example.facelookapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationBarGraph(
    navItemController: NavHostController,
    navRootController: NavHostController
) {
    // Make sure navController is correctly labeled
    NavHost(
        navController = navItemController, // Explicitly specify the navController parameter
        startDestination = NavItem.Home.item_route // Correctly specify the start destination
    ) {
        composable(NavItem.Home.item_route) {
            HomeScreen(navRootController) // Passing navRootController correctly here
        }
        composable(NavItem.Watch.item_route) {
            WatchScreen()
        }
        composable(NavItem.Friend.item_route) {
            FriendScreen()
        }
        composable(NavItem.Marketplace.item_route) {
            MarketplaceScreen()
        }
        composable(NavItem.Notification.item_route) {
            NotificationScreen()
        }
    }
}
