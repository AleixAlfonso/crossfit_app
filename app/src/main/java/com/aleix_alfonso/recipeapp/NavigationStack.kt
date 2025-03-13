package com.aleix_alfonso.recipeapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aleix_alfonso.recipeapp.data.models.Screen
import com.aleix_alfonso.recipeapp.data.repository.ClassRepository
import com.aleix_alfonso.recipeapp.data.source.remote.ClassDataSource
import com.aleix_alfonso.recipeapp.screens.home.HomeViewModel
import com.aleix_alfonso.recipeapp.screens.home.ui.HomeScreen
import com.aleix_alfonso.recipeapp.screens.horarios.HorariosViewModel
import com.aleix_alfonso.recipeapp.screens.horarios.ui.ScheduleScreen
import com.aleix_alfonso.recipeapp.screens.information.ui.InformationScreen
import com.aleix_alfonso.recipeapp.screens.login.ui.LoginScreen
import com.aleix_alfonso.recipeapp.screens.notifications.NotificationsScreen
import com.aleix_alfonso.recipeapp.screens.profile.ProfileScreen
import com.aleix_alfonso.recipeapp.screens.shop.ui.ShopItemDetails

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationStack(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    showBottomBar: (Boolean) -> Unit,
) {

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route,
    ) {
        composable(route = Screen.Login.route){
            showBottomBar(false)
            LoginScreen()
        }
        composable(route = Screen.Home.route) {
            showBottomBar(true)
            val viewModel = remember { HomeViewModel() }
            HomeScreen(
                arrowBackEnabled = false,
                viewModel = viewModel, navController = navController
            )
        }
        composable(route = Screen.Notifications.route) {
            showBottomBar(true)

            NotificationsScreen(navController = navController)
        }
        composable(route = Screen.Profile.route) {
            showBottomBar(true)
            ProfileScreen(navController = navController)
        }
        composable(route = Screen.Schedule.route) {
            showBottomBar(false)
            val classDataSource: ClassDataSource = remember { ClassDataSource() }
            val clasRepository = remember { ClassRepository(classDataSource) }
            val viewModel = remember { HorariosViewModel(clasRepository) }
            ScheduleScreen(viewModel = viewModel, { navController.popBackStack() })
        }
        composable(route = Screen.Information.route) {
            showBottomBar(false)
            InformationScreen()
        }
        composable(route = Screen.ShopCardDetail.route + "/{shopItem}") { entry ->
            showBottomBar(false)
            ShopItemDetails(itemId = entry.arguments?.getInt("shopItem")!!)
        }
    }

}