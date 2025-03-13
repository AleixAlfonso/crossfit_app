package com.aleix_alfonso.recipeapp.screens.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aleix_alfonso.recipeapp.R
import com.aleix_alfonso.recipeapp.data.models.Screen

@Composable
fun CrossfitSection(
    homeOnClick: (String) -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box {
        Column {
            Row {
                Image(
                    painter = painterResource(R.drawable.crossfit_icon),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(bottom = 24.dp)
                        .clip(CircleShape)
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Crossfit Lleida",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 16.sp,
                    )
                    Text(
                        text = "Crossfit Lleida", fontWeight = FontWeight.Bold, fontSize = 12.sp
                    )
                }
            }
            Button(
                onClick = { TODO() },
                shape = RoundedCornerShape(0),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text(text = "Reservar", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
            Column(
                modifier = Modifier.border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(6)
                )
            ) {
                HomeIconButton(
                    Icons.Filled.CalendarMonth,
                    "Horario",
                    homeOnClick,
                    Screen.Schedule.route
                )
                HorizontalDivider(color = Color.Gray, thickness = 1.dp)
                HomeIconButton(
                    Icons.Outlined.Info,
                    "Más información",
                    homeOnClick,
                    Screen.Information.route
                )

            }


        }
    }

}


@Composable
fun HomeIconButton(
    icon: ImageVector,
    text: String,
    homeOnClick: (String) -> Unit,
    ruta: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable(onClick = { homeOnClick(ruta) })
            .padding(16.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.size(12.dp))
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(20.dp)
        )
    }
}