package com.ostapr.narutocards.core.database.di

import android.content.Context
import androidx.room.Room
import com.ostapr.narutocards.core.database.NarutoCardsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideNarutoCardsDatabase(@ApplicationContext context: Context): NarutoCardsDatabase =
        Room.databaseBuilder(context, NarutoCardsDatabase::class.java, "naruto_cards_database")
            .build()
}