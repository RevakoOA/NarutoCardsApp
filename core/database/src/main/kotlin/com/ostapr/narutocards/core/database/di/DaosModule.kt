package com.ostapr.narutocards.core.database.di

import com.ostapr.narutocards.core.database.NarutoCardsDatabase
import com.ostapr.narutocards.core.database.dao.AnimeCharactersDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
internal class DaosModule {
    @Provides
    fun provideAnimeCharactersDao(db: NarutoCardsDatabase): AnimeCharactersDao =
        db.animeCharactersDao()

}