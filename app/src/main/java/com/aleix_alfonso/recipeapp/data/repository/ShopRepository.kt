package com.aleix_alfonso.recipeapp.data.repository

import com.aleix_alfonso.recipeapp.data.models.ShopDomainModel
import com.aleix_alfonso.recipeapp.data.source.remote.ShopItemDataResource

class ShopRepository(private val shopItemDataResource: ShopItemDataResource) {


    fun putShopItems() {
        shopItemDataResource.postShopItems()
    }
    suspend fun getShopItems(): List<ShopDomainModel>{
        return shopItemDataResource.getShopItems()
    }
}