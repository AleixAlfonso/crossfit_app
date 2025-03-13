package com.aleix_alfonso.recipeapp.data.repository

import com.aleix_alfonso.recipeapp.data.models.ClassDomainModel
import com.aleix_alfonso.recipeapp.data.source.remote.ClassDataSource

class ClassRepository(private val classDataSource: ClassDataSource) {

    suspend fun getClasses(): List<ClassDomainModel>{
        return classDataSource.getClasses()
    }
    fun postClasses(){
        classDataSource.postClasses()
    }
}