package com.uc.chalk.view

import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.uc.chalk.viewmodel.MainViewModel

@Composable
fun BottomNavGraph(navController: NavHostController,lifecycleOwner: LifecycleOwner, mainViewModel: MainViewModel) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(route = Screen.Home.route){
            HomeScreen(lifecycleOwner, mainViewModel)
        }
        composable(route = Screen.Chat.route){
            ChatScreen(lifecycleOwner,mainViewModel)
        }
        composable(route = Screen.Contact.route){
//            ContactScreen()
            ContactScreen(lifecycleOwner,mainViewModel)
        }
    }
}