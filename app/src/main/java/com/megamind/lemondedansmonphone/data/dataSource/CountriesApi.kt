package com.megamind.lemondedansmonphone.data.dataSource

import retrofit2.Response

interface ContriesApi {

    suspend fun getContries(): Response<>
}