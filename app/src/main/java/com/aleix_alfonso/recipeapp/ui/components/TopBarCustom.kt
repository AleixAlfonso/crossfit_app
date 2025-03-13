package com.aleix_alfonso.recipeapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBarCustom(
    title: String,
    onArrowBackClick: () -> Unit,
    arrowBackEnabled: Boolean,
    modifier: Modifier = Modifier,
    actions: List<@Composable () -> Unit> = listOf<@Composable () -> Unit>(),
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            if (arrowBackEnabled){
                IconButton(onArrowBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Arrow Back",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }

            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.weight(1f))
            actions.forEach {
                it()
            }
        }

    }

}