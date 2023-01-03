package com.uc.chalk.view

const val DETAIL_ARGUMENT_KEY = "id"

sealed class Screen (val route: String){
    object Home: Screen(route = "home_screen")
//    object Splash: Screen(route = "splash_screen") //add /{$DETAIL_ARGUMENT_KEY} kalau mau kirim id dsb
//    {
//        fun passId(id: Int): String {
//            return this.route.replace(oldValue = "{$DETAIL_ARGUMENT_KEY}", newValue = id.toString())
//        }
//    }
    object Contact: Screen(route = "contact_screen")
    object Chat: Screen(route = "chat_screen")
    object Profile: Screen(route = "editprofile_screen")
}
