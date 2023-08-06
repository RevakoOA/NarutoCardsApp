package com.ostapr.narutocards.core.network.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.ostapr.narutocards.core.network.NarutoDataSource
import com.ostapr.narutocards.core.network.model.NetworkAnimeCharacter
import com.ostapr.narutocards.core.network.retrofit.api.RetrofitNarutoNetworkApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitNarutoNetwork @Inject constructor(
    networkJson: Json,
) : NarutoDataSource {

    private val networkApi: RetrofitNarutoNetworkApi =
        Retrofit.Builder().baseUrl(RetrofitNarutoNetworkApi.BASE_URL)
            .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(RetrofitNarutoNetworkApi::class.java)

    override suspend fun getCharacters(): List<NetworkAnimeCharacter> {
        return networkApi.getAllCharacters().value
    }

}