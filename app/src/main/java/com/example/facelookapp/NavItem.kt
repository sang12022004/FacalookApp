package com.example.facelookapp

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Groups
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.ShoppingBag
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.VideoLibrary
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavItem(var icon: ImageVector, var item_route: String){
    object Home: NavItem(Icons.Rounded.Home,"home")
    object Watch: NavItem(Icons.Rounded.VideoLibrary,"video")
    object Friend: NavItem(Icons.Rounded.Groups,"friend")
    object Marketplace: NavItem(Icons.Rounded.ShoppingCart,"marketplace")
    object Notification: NavItem(Icons.Rounded.Notifications,"notification")
}