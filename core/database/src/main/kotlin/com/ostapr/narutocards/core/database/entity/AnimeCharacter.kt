package com.ostapr.narutocards.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ostapr.narutocards.core.model.AnimeCharacter

@Entity("anime_characters")
internal data class AnimeCharacterEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val images: List<String>,
    val family: Map<String, String>,
    val jutsus: List<String>,
    val natureTypes: List<String>,
    val ranks: Map<String, String>,
    val uniqueTraits: List<String>,
)

internal fun AnimeCharacterEntity.asExternalModel() = AnimeCharacter(
    id = id,
    name = name,
    images = images,
    family = family,
    jutsus = jutsus,
    natureTypes = natureTypes,
    ranks = ranks,
)
