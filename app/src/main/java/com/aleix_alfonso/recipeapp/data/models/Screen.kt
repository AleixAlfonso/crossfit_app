package com.aleix_alfonso.recipeapp.data.models

sealed class Screen(val route: String) {
    object Home: Screen("main_screen")
    object Notifications: Screen("notifications_screen")
    object Profile: Screen("profile_screen")
    object Schedule: Screen("schedule_screen")
    object Information: Screen("information_screen")
    object ShopCardDetail: Screen("shop_card_detail_screen")
    object Login: Screen("login_screen")
}