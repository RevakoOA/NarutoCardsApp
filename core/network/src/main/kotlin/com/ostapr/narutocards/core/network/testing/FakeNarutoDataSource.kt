package com.ostapr.narutocards.core.network.testing

import com.ostapr.narutocards.core.network.NarutoDataSource
import com.ostapr.narutocards.core.network.model.NetworkAnimeCharacter

class FakeNarutoDataSource: NarutoDataSource {
    override suspend fun getCharacters(): List<NetworkAnimeCharacter> {
        return emptyList()
    }
}