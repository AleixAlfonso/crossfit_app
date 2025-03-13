package com.aleix_alfonso.recipeapp.screens.home.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aleix_alfonso.recipeapp.data.models.ShopDomainModel


@Composable
fun TiendaSectionContent(
    shopItems: List<ShopDomainModel>,
    onClickCard: (ShopDomainModel) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier.requiredWidth(LocalConfiguration.current.screenWidthDp.dp),
        contentPadding = PaddingValues(24.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(shopItems) {
            ShopCard(shopItem = it, onClickCard = onClickCard)
        }
    }
}

@SuppressLint("DiscouragedApi")
@Composable
fun ShopCard(
    shopItem: ShopDomainModel,
    onClickCard: (ShopDomainModel) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        modifier = modifier
            .width(100.dp)
            .padding(bottom = 12.dp)
            .clickable(onClick = { onClickCard(shopItem) })
    ) {
        Column {
            val context = LocalContext.current
            val resourceID =
                context.resources.getIdentifier(shopItem.imageUrl, "drawable", context.packageName)
            Image(painter = painterResource(resourceID), contentDescription = null)
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = shopItem.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "${shopItem.price} ${shopItem.currency}",
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Gray,
                    fontSize = 16.sp
                )
            }

        }

    }
}