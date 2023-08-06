package com.ostapr.narutocards.core.network.model

data class NetworkAnimeCharacter(
    val id: String,
    val name: String,
    val images: List<String>,
    val family: Map<String, String>,
    val jutsus: List<String>,
    val natureTypes: List<String>,
    val ranks: Map<String, String>
)
