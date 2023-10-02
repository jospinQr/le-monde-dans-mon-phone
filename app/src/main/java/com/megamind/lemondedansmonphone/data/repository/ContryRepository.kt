package com.megamind.lemondedansmonphone.data.repository

import androidx.lifecycle.LiveData
import com.megamind.lemondedansmonphone.data.dataSource.CountriesApi
import com.megamind.lemondedansmonphone.domain.model.Country
import com.megamind.lemondedansmonphone.util.Resource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class CountryRepository @Inject constructor(
    private val api: CountriesApi
) {



    suspend fun getCountries() = api.getContries()
//    suspend fun getContries() = flow{
//        emit(Resource.Loading())
//        val countries = api.getContries().body()?.countries
//        emit(Resource.Success(countries))
//    }.catch {error->
//        emit(Resource.Error(error.message!!))
//    }

}