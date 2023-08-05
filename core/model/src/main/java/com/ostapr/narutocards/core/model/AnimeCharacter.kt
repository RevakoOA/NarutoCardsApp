package com.ostapr.narutocards.core.model

data class AnimeCharacter(
    val id: Int,
    val name: String,
    val images: List<String>,
    val family: Map<String, String>,
    val jutsus: List<String>,
    val natureTypes: List<String>,
    val ranks: Map<String, String>
)