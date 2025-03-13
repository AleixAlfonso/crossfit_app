package com.aleix_alfonso.recipeapp.screens.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun ProfileScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {

    Surface(modifier = modifier
        .fillMaxSize()) {
        Box {
            Text(text = "Hello Profile")

        }

    }

}