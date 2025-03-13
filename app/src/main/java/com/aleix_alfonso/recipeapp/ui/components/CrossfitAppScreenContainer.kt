package com.aleix_alfonso.recipeapp.ui.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CrossfitAppScreenContainer(
    content: @Composable ColumnScope.(PaddingValues) -> Unit,
    isLoading:Boolean = false,
    scrollEnabled: Boolean = true,
    contentPaddingValues: PaddingValues = PaddingValues(start = 24.dp, end = 24.dp),
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    actionButton: @Composable () -> Unit = {},
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.LightGray
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val columnModifier =
        if (scrollEnabled) Modifier.verticalScroll(rememberScrollState()) else Modifier
    val scrollModifier =
        if (scrollEnabled) Modifier.nestedScroll(scrollBehavior.nestedScrollConnection) else Modifier
    Box(modifier = modifier.fillMaxSize()) {
        Surface(color = backgroundColor) {
            Scaffold(
                topBar = topBar ,
                bottomBar = bottomBar,
                content = { paddingValues ->
                    Column(
                        modifier = columnModifier
                            .padding(
                                bottom = paddingValues.calculateBottomPadding(),
                                top = paddingValues.calculateTopPadding(),
                                start = contentPaddingValues.calculateStartPadding(
                                    LocalLayoutDirection.current
                                ),
                                end = contentPaddingValues.calculateEndPadding(LocalLayoutDirection.current)
                            )
                            .fillMaxSize()

                    ) {
                        content(contentPaddingValues)
                    }
                },
                modifier = Modifier
                    .fillMaxSize()
                    .then(scrollModifier)

            )
        }
        if (isLoading) {
            LoadingOverlay()
        }
    }
}

@Composable
fun LoadingOverlay() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}
