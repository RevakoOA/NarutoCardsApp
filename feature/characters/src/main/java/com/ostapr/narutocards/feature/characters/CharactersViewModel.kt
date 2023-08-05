package com.ostapr.narutocards.feature.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ostapr.narutocards.core.model.AnimeCharacter
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.stateIn

class CharactersViewModel : ViewModel() {
    val characters: StateFlow<List<AnimeCharacter>> = emptyFlow<List<AnimeCharacter>>().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList()
    )

}