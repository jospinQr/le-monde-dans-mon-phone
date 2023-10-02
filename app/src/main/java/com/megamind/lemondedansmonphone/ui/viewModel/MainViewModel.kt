package com.megamind.lemondedansmonphone.ui.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.megamind.lemondedansmonphone.data.repository.CountryRepository
import com.megamind.lemondedansmonphone.domain.model.Country
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.megamind.lemondedansmonphone.util.Resource
import kotlinx.coroutines.launch


@HiltViewModel
class MainViewModel @Inject constructor(private val contryRepository: CountryRepository) :
    ViewModel() {

    private val _countries = MutableLiveData<List<Country>>()

    val countries: LiveData<List<Country>> = _countries

    init {
        getCoutries()
    }

    fun getCoutries() {
        viewModelScope.launch {
            val countries = contryRepository.getCountries()
            _countries.value = countries
        }

    }

}


data class UiState(

    val isLoding: Boolean = false,
    val error: String? = null,
    val countries: List<Country>? = emptyList()


)