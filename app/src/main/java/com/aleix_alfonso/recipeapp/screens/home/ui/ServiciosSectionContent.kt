package com.aleix_alfonso.recipeapp.screens.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aleix_alfonso.recipeapp.data.models.ServiceDomainModel

@Composable
fun ServiciosSectionContent(
    services: List <ServiceDomainModel>,
    servicesOnClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        contentPadding = PaddingValues(start = 24.dp, end = 24.dp),
        modifier = modifier.requiredWidth(LocalConfiguration.current.screenWidthDp.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(services){service->
            ServiceCard(service,servicesOnClick)
        }
    }
}


@Composable
fun ServiceCard(service:ServiceDomainModel,servicesOnClick: () -> Unit, modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth(0.85f)
            .height(150.dp)
            .aspectRatio(2f)
            .clickable(onClick = servicesOnClick),
    ) {
        Box {
            Image(
                painter = painterResource(service.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .align(Alignment.BottomCenter)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.7f)
                            ),
                            startY = 0f,
                            endY = Float.POSITIVE_INFINITY
                        )
                    )
            )
            Text(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp),
                text = service.title,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
                color = Color.White,

                )
        }
    }
}