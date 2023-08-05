package com.ostapr.narutocards.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.ostapr.narutocards.core.database.entity.AnimeCharacterEntity

import kotlinx.coroutines.flow.Flow

@Dao
internal interface AnimeCharactersDao {

    @Query(
        """
            SELECT * FROM anime_characters
            ORDER BY id ASC
        """
    )
    fun getAnimeCharacters(): Flow<List<AnimeCharacterEntity>>
}