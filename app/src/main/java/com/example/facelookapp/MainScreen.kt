package com.example.facelookapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.rounded.Adb
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.facelookapp.ui.theme.FaceLookAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navRootController: NavHostController,
               modifier: Modifier = Modifier){
    var navItemController = rememberNavController()
    var items = listOf(
        NavItem.Home, NavItem.Watch, NavItem.Friend,
        NavItem.Marketplace, NavItem.Notification
    )
    Scaffold (
        topBar = {
            Column {
                TopAppBar(
                    title = {
                        Text(
                            text = "Facalook",
                            color = Color(4284542002),
                            fontSize = 25.sp, fontWeight = FontWeight.ExtraBold
                        )
                    },
                    actions = {
                        Icon(
                            imageVector = Icons.Rounded.Add,
                            contentDescription = "Add"
                        )
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            contentDescription = "search"
                        )
                        Icon(
                            imageVector = Icons.Filled.Send,
                            contentDescription = "Mess"
                        )
                    }
                )
                Divider()
            }
        },
        bottomBar = {
            Column {
                Divider()
                NavigationAppBar(navController = navItemController)
            }
        }
    ) {
        Box(modifier = modifier.padding(it)) {
            NavigationBarGraph(
                navItemController = navItemController,
                navRootController = navRootController
            )
        }
    }
}