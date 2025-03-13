package com.aleix_alfonso.recipeapp.data.models


data class ClassDomainModel(
    val start: String="",
    val end: String="",
    val type:String="",
    val subType:String="",
    val days:List<String> = listOf<String>()
)

