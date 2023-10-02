package com.megamind.lemondedansmonphone.data.dataSource

import androidx.lifecycle.LiveData
import com.megamind.lemondedansmonphone.domain.model.CountriesResponse
import com.megamind.lemondedansmonphone.domain.model.Country
import retrofit2.Response
import retrofit2.http.GET

interface CountriesApi {
    @GET("all")
    suspend fun getContries(): List<Country>


}