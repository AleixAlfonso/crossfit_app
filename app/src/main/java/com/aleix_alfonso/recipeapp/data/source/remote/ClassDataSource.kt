package com.aleix_alfonso.recipeapp.data.source.remote

import android.util.Log
import com.aleix_alfonso.recipeapp.data.models.ClassDomainModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await

class ClassDataSource() {
    private val db = Firebase.firestore
    private val classCollection = db.collection("classes")


    suspend fun getClasses(): List<ClassDomainModel> {
        return try {
            db.collection("classes").get().await().mapNotNull {
                Log.i("ClassDataSource", "getClasses: $it")
                it.toObject(ClassDomainModel::class.java)

            }
        } catch (e: Exception) {
            Log.i("Error", e.message.toString())
            emptyList()
        }
    }



    fun postClasses() {
        var classList = listOf<ClassDomainModel>(
            ClassDomainModel(
                start = "11:30",
                end = "12:30",
                type = "CROSSFIT",
                subType = "CROSSFIT",
                days = listOf("M")
            ),
            ClassDomainModel(
                start = "11:30",
                end = "12:30",
                type = "CROSSFIT",
                subType = "OPEN BOX SALA ESCART",
                days = listOf("L")
            ),
            ClassDomainModel(
                start = "11:30",
                end = "12:30",
                type = "CROSSFIT",
                subType = "LLIURE - OPOS",
                days = listOf("X")
            ),
            ClassDomainModel(
                start = "11:30",
                end = "12:30",
                type = "CROSSFIT",
                subType = "PERFORMANCE",
                days = listOf("J")
            ),
            ClassDomainModel(
                start = "11:30",
                end = "12:30",
                type = "CROSSFIT",
                subType = "OPEN BOX ENTRADA",
                days = listOf("V")
            ),
            ClassDomainModel(
                start = "11:30",
                end = "12:30",
                type = "CROSSFIT",
                subType = "LLIURE - OPOS",
                days = listOf("S")
            ),
            ClassDomainModel(
                start = "11:30",
                end = "12:30",
                type = "CROSSFIT",
                subType = "LLIURE - OPOS",
                days = listOf("D")
            )
        )
        for (classItem in classList) {
            db.collection("classes").add(classItem)
        }




    }
}
