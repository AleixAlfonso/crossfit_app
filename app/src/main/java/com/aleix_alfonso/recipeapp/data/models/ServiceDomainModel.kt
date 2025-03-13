package com.aleix_alfonso.recipeapp.data.models

import android.icu.text.CaseMap
import androidx.annotation.DrawableRes

data class ServiceDomainModel(
    @DrawableRes val image:Int,
    val title:String,
    val id:Int,

)