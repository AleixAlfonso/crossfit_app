package com.aleix_alfonso.recipeapp.screens.horarios

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aleix_alfonso.recipeapp.data.models.ClassDomainModel
import com.aleix_alfonso.recipeapp.data.models.ScheduleDomainModel
import com.aleix_alfonso.recipeapp.data.repository.ClassRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HorariosViewModel(private val classRepository: ClassRepository) : ViewModel() {

    private val _state = MutableStateFlow<HorariosViewState>(HorariosViewState.Initial())
    val state: StateFlow<HorariosViewState> = _state.asStateFlow()


    init {
        getHorarios()
    }


    fun getHorarios() {
        _state.value = HorariosViewState.Loading()

        viewModelScope.launch {
            _state.value = HorariosViewState.Active(
                ScheduleDomainModel(
                    classList = classRepository.getClasses()

                )
            )
        }
    }
}


sealed class HorariosViewState() {
    class Initial() : HorariosViewState()
    class Active(val horariosDomainModel: ScheduleDomainModel) : HorariosViewState()
    class Loading() : HorariosViewState()
}