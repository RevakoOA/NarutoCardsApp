package com.ostapr.narutocards.core.network.di

import com.ostapr.narutocards.core.network.NarutoDataSource
import com.ostapr.narutocards.core.network.testing.FakeNarutoDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface FlavoredNetworkModule {
    @Binds
    fun FakeNarutoDataSource.binds(): NarutoDataSource

}