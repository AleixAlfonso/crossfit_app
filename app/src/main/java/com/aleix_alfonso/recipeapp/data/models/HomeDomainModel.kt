package com.aleix_alfonso.recipeapp.data.models

data class HomeDomainModel(
    val shopItems: List<ShopDomainModel>,
    val serviceItems:List<ServiceDomainModel>
)