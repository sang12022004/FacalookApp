package com.example.facelookapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

sealed class NavRoot(val router: String) {
    object Root : NavRoot("root")
    object Main : NavRoot("main")
    object Post : NavRoot("post")
}

@Composable
fun RootGraph(navRootController: NavHostController) {
    NavHost(
        navController = navRootController,
        startDestination = NavRoot.Main.router
    ) {
        composable(NavRoot.Main.router) {
            MainScreen(navRootController)
        }
        composable(NavRoot.Post.router) {
            CreatePostScreen(navtController = navRootController)
        }
    }
}
