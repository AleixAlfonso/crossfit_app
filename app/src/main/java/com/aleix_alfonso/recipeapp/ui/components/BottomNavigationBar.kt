package com.aleix_alfonso.recipeapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.aleix_alfonso.recipeapp.data.models.getNavigationItems


@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    onNavigationClick: (String) -> Unit
) {

    NavigationBar(content = {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            getNavigationItems().forEachIndexed { index, item ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable(onClick = { onNavigationClick(item.route) })
                ) {
                    Icon(imageVector = item.icon, contentDescription = item.label)
                    Text(text = item.label)
                }
            }

        }

    }
    )

}