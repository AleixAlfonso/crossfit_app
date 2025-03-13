package com.aleix_alfonso.recipeapp.data.source.remote

import android.util.Log
import com.aleix_alfonso.recipeapp.data.models.ShopDomainModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await

class ShopItemDataResource {

    private val db = Firebase.firestore
    private val shopItemsCollection = db.collection("shopItems")


    private val shopItems: List<ShopDomainModel> = listOf(
        ShopDomainModel(
            imageUrl = "tiendaicon",
            id = 1,
            title = "Item de prueba 1",
            price = 12.0,
            description = "Esto es una prueba de descripción",
            currency = "€"
        )
    )

    fun postShopItems() {
        repeat(10) {
            db.collection("shopItems").add(shopItems[it])

        }
    }

    suspend fun getShopItems(): List<ShopDomainModel> {
        return try {
            db.collection("shopItems").get().await().mapNotNull {
                it.toObject(ShopDomainModel::class.java)
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}
