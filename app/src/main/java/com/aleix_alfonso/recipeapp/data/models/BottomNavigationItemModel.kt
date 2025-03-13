package com.aleix_alfonso.recipeapp.data.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItemModel(
    val icon: ImageVector,
    val label: String,
    val route: String,
    val selected: Boolean = false,
)

fun getNavigationItems(): List<BottomNavigationItemModel> {
    return listOf(
        BottomNavigationItemModel(
            icon = Icons.Default.Home,
            label = "Home",
            route = Screen.Home.route
        ),
        BottomNavigationItemModel(
            icon = Icons.Default.Notifications,
            label = "Notifications",
            route = Screen.Notifications.route
        ),
        BottomNavigationItemModel(
            icon = Icons.Default.Person,
            label = "Perfil",
            route = Screen.Profile.route
        )
    )
}