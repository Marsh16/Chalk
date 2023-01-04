package com.uc.chalk.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon_filled: ImageVector,
    val icon_outlined: ImageVector
){
    object Home: BottomBarScreen(
        route = "home_screen",
        title = "",
        icon_filled = Icons.Default.Home,
        icon_outlined = Icons.Outlined.Home
    )
    object Chat: BottomBarScreen(
        route = "chat_screen",
        title = "",
        icon_filled = Icons.Default.Chat,
        icon_outlined = Icons.Outlined.Chat
    )
    object Contact: BottomBarScreen(
        route = "contact_screen",
        title = "",
        icon_filled = Icons.Default.Person,
        icon_outlined = Icons.Outlined.Person
    )
}
