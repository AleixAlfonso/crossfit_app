package com.aleix_alfonso.recipeapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.aleix_alfonso.recipeapp.R

@Composable
fun ReservarFloatingActionButton(modifier: Modifier = Modifier) {
    FloatingActionButton(onClick = { TODO() }, content = {
        Row(
            modifier = Modifier
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(imageVector = Icons.Default.CalendarToday, contentDescription = null)
            Text(
                text = stringResource(R.string.reservar),
                modifier = Modifier.align(alignment = Alignment.CenterVertically)
            )
        }
    })
}