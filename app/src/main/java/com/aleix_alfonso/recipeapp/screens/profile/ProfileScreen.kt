package com.aleix_alfonso.recipeapp.screens.profile

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun ProfileScreen(
    navController: NavHostController,
    onLogout: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Surface(
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(text = "In progress")
    }

}