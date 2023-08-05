package com.ostapr.narutocards.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ostapr.narutocards.core.database.dao.AnimeCharactersDao
import com.ostapr.narutocards.core.database.entity.AnimeCharacterEntity

@Database(
    entities = [
        AnimeCharacterEntity::class,
    ],
    version = 1,
    exportSchema = true,
)
internal abstract class NarutoCardsDatabase: RoomDatabase() {
    abstract fun animeCharactersDao(): AnimeCharactersDao
}