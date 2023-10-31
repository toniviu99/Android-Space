package com.example.spaceapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spaceapp.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase) : ViewModel() {

    private var _state = MutableStateFlow<MainState>(MainState.Loading)
    val state:StateFlow<MainState> = _state

    fun getPictures(date:String, apiKey:String){
        viewModelScope.launch {
            _state.value = MainState.Loading
            val result = withContext(Dispatchers.IO){ getPredictionUseCase(date, apiKey) }
            if (result != null){
                _state.value = MainState.Success(result)
            } else{
                _state.value = MainState.Error("Ha ocurrido un error, intentelo mas tarde")
            }

        }
    }
}