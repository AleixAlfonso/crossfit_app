package com.aleix_alfonso.recipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aleix_alfonso.recipeapp.ui.components.BottomNavigationBar
import com.aleix_alfonso.recipeapp.ui.components.CrossfitAppScreenContainer
import com.aleix_alfonso.recipeapp.ui.theme.RecipeAppTheme
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipeAppTheme {
                var showBottomBar by remember { mutableStateOf(true) }
                val routes = listOf("schedule_screen")
                val navController: NavHostController = rememberNavController()

                CrossfitAppScreenContainer(
                    contentPaddingValues = PaddingValues(all = 0.dp),
                    scrollEnabled = false,
                    bottomBar = {
                        if (showBottomBar) {
                            BottomNavigationBar(
                                onNavigationClick = {
                                    navController.navigate(
                                        it
                                    )
                                }
                            )
                        }

                    }, content = { paddingValues ->
                        NavigationStack(
                            navController = navController,
                            showBottomBar = { showBottomBar = it },
                        )

                    }
                )

            }
        }
    }
}

@Composable
fun BackNavigationIcon(onArrowBackClick: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(onClick = { onArrowBackClick() }) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}