package com.aleix_alfonso.recipeapp.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aleix_alfonso.recipeapp.data.models.HomeDomainModel
import com.aleix_alfonso.recipeapp.data.models.ServiceDomainModel
import com.aleix_alfonso.recipeapp.data.repository.ShopRepository
import com.aleix_alfonso.recipeapp.data.source.remote.ShopItemDataResource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.aleix_alfonso.recipeapp.R

class HomeViewModel : ViewModel() {
    val shopItemDataResource = ShopItemDataResource()
    val shopRepository = ShopRepository(shopItemDataResource)
    private val _state = MutableStateFlow<HomeViewState>(HomeViewState.Initial())
    val state: StateFlow<HomeViewState> = _state.asStateFlow()


    fun getHomeData() {
        _state.value = HomeViewState.Loading()
        viewModelScope.launch {
            _state.value = HomeViewState.Active(

                HomeDomainModel(
                    shopItems = shopRepository.getShopItems(),
                    listOf(
                        ServiceDomainModel(
                            image = R.drawable.crossfit,
                            title = "CROSSFIT",
                            id = 1
                        ),
                        ServiceDomainModel(
                            image = R.drawable.study,
                            title = "OPOS",
                            id = 2
                        )
                    )
                )
            )
        }
    }
}


sealed class HomeViewState {
    class Initial() : HomeViewState()
    class Active(val homeDomainModel: HomeDomainModel) : HomeViewState()
    class Loading() : HomeViewState()
}


