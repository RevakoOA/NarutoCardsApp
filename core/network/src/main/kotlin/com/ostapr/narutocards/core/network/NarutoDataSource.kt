package com.ostapr.narutocards.core.network

import com.ostapr.narutocards.core.network.model.NetworkAnimeCharacter

interface NarutoDataSource {
    suspend fun getCharacters(): List<NetworkAnimeCharacter>
}