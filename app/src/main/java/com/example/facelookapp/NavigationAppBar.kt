package com.example.facelookapp

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun NavigationAppBar(navController: NavHostController) {
    val items = listOf(
        NavItem.Home,
        NavItem.Watch,
        NavItem.Friend,
        NavItem.Marketplace,
        NavItem.Notification
    )

    NavigationBar(
        containerColor = Color.Transparent
    ) {
        val navBackStackEntry = navController.currentBackStackEntryAsState().value
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = ""
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Blue
                ),
                alwaysShowLabel = false,
                selected = currentRoute == item.item_route,
                onClick = {
                    navController.navigate(item.item_route) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
