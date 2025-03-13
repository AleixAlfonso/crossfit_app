package com.aleix_alfonso.recipeapp.screens.home.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.aleix_alfonso.recipeapp.R
import com.aleix_alfonso.recipeapp.screens.home.HomeViewModel
import com.aleix_alfonso.recipeapp.screens.home.HomeViewState
import com.aleix_alfonso.recipeapp.ui.components.CrossfitAppScreenContainer
import com.aleix_alfonso.recipeapp.ui.components.ReservarFloatingActionButton
import com.aleix_alfonso.recipeapp.ui.components.TopBarCustom
import com.aleix_alfonso.recipeapp.ui.components.section.Section

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navController: NavHostController,
    arrowBackEnabled: Boolean = true,
    modifier: Modifier = Modifier,
) {
    val viewState = viewModel.state.collectAsState()


    CrossfitAppScreenContainer(
        scrollEnabled = true,

        topBar = {
            TopBarCustom(
                title = "Crossfit Lleida",
                onArrowBackClick = { navController.popBackStack() },
                arrowBackEnabled = arrowBackEnabled
            )
        },
        actionButton = { ReservarFloatingActionButton() },
        isLoading = viewState.value is HomeViewState.Loading,
        content = {
            Spacer(modifier = Modifier.height(24.dp))
            CrossfitSection(homeOnClick = { it ->
                navController.navigate(it)
            }, navController = navController)

            Spacer(modifier = Modifier.height(24.dp))
            when (val state = viewState.value) {
                is HomeViewState.Initial -> {
                    viewModel.getHomeData()
                }

                is HomeViewState.Active -> {
                    Section(content = {
                        TiendaSectionContent(
                            state.homeDomainModel.shopItems,
                            onClickCard = { it ->
                                navController.navigate("shop_card_detail_screen/")
                            })

                    }, title = stringResource(R.string.tienda), onClickHeader = {})
                    Section(content = {
                        ServiciosSectionContent(
                            state.homeDomainModel.serviceItems,
                            servicesOnClick = {})
                    }, title = stringResource(R.string.servicios), onClickHeader = { TODO() })
                }

                else -> {}
            }


        }

    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenTopBar(
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    HomeTopBar(
        scrollBehavior = scrollBehavior,
        title = "Crossfit LLeida",
        actions = {
            Text(
                color = MaterialTheme.colorScheme.onPrimary,
                text = "Mis centros",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .clickable(onClick = { TODO() })
            )
        }
    )
}