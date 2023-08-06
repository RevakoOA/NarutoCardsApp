package com.ostapr.narutocards.core.network.retrofit.api

import com.ostapr.narutocards.core.network.model.NetworkAnimeCharacter
import retrofit2.http.GET
import retrofit2.http.Query

internal interface RetrofitNarutoNetworkApi {
    @GET("character")
    suspend fun getAllCharacters(@Query("page") page: Int = 1, @Query("limit") pageLimit: Int = 20): NetworkResponse<List<NetworkAnimeCharacter>>

    companion object {
        const val BASE_URL = "https://narutodb.xyz/api/"
    }
}
