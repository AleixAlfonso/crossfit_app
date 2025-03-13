package com.aleix_alfonso.recipeapp.data.models

import androidx.annotation.DrawableRes
import kotlinx.serialization.Serializable
import com.aleix_alfonso.recipeapp.R

@Serializable
data class ShopDomainModel(
    val imageUrl:String = "tiendaicon",
    val id: Int = 0,
    val title: String = "Error",
    val price: Double = 12.0,
    val description: String  = "Test descripcion",
    val currency: String ="€",
)