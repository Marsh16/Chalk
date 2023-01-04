package com.uc.chalk.view

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(route = Screen.Home.route){
            HomeScreen()
        }
        composable(route = Screen.Chat.route){
            ChatScreen()
        }
        composable(route = Screen.Contact.route){
            ContactScreen()
        }
    }
}