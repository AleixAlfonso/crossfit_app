package com.aleix_alfonso.recipeapp.ui.components.section

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun Section(
    content: @Composable () -> Unit,
    title: String,
    onClickHeader: () -> Unit,
) {
    Box {
        Column {
            SectionHeader(title, onClickHeader = onClickHeader)
            Row {
                content()
            }
        }
    }
}


