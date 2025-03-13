package com.aleix_alfonso.recipeapp.ui.components.section

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun SectionHeader(title: String, onClickHeader: () -> Unit, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth()) {
        Text(text = title, fontWeight = FontWeight.ExtraBold, fontSize = 24.sp)
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier.clickable(onClick = onClickHeader),
            text = "Ver todo",
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Right
        )

    }
}