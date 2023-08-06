package com.ostapr.narutocards.core.network.di

import com.ostapr.narutocards.core.network.retrofit.RetrofitNarutoNetwork
import com.ostapr.narutocards.core.network.NarutoDataSource
import dagger.Module
import dagger.Binds
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Binds
    fun RetrofitNarutoNetwork.binds(): NarutoDataSource
}