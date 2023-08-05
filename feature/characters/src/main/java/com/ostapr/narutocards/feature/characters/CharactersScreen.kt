package com.ostapr.narutocards.feature.characters

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import com.ostapr.narutocards.core.designsystem.theme.NarutocardsTheme
import com.ostapr.narutocards.core.model.AnimeCharacter

@Composable
internal fun CharactersRoute(
    onCharacterClicked: (AnimeCharacter) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CharactersViewModel = hiltViewModel()
) {
    val characters by viewModel.characters.collectAsStateWithLifecycle()
    CharactersScreen(characters, onCharacterClicked, modifier)
}

@Composable
internal fun CharactersScreen(
    characters: List<AnimeCharacter>,
    onCharacterClicked: (AnimeCharacter) -> Unit,
    modifier: Modifier = Modifier,
) {
    val state = rememberLazyGridState()

    LazyVerticalGrid(columns = GridCells.Adaptive(140.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier,
        state = state,
        content = {
        items(characters) {
            CharacterItem(character = it, onCharacterClicked = onCharacterClicked)
        }
    })
}

@Composable
internal fun CharacterItem(
    character: AnimeCharacter,
    onCharacterClicked: (AnimeCharacter) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier.aspectRatio(4 / 5f)) {
        Box(Modifier.fillMaxSize()) {
            Image(
                painter = rememberAsyncImagePainter(character.images[0]),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .align(Alignment.TopStart)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.verticalGradient(
                            0f to Color.Transparent,
                            0.25f to MaterialTheme.colorScheme.primaryContainer,
                        )
                    )
                    .padding(start = 8.dp, top = 16.dp, end = 8.dp, bottom = 8.dp)
                    .align(Alignment.BottomStart)
            ) {
                Text(character.name)
                Text(character.jutsus[0])
            }
        }
    }
}

private val sampleCharacter = AnimeCharacter(
    id = 0,
    name = "Zero-Tails",
    images = listOf("https://static.wikia.nocookie.net/naruto/images/8/87/Zero_tails.PNG/revision/latest/scale-to-width-down/300?cb=20120518185128"),
    family = emptyMap(),
    jutsus = listOf("Shadow Arms"),
    natureTypes = emptyList(),
    ranks = emptyMap()
)

@Preview(widthDp = 160)
@Composable
internal fun CharacterItemPreview() {
    NarutocardsTheme {
        CharacterItem(character = sampleCharacter, onCharacterClicked = { })
    }
}

@Preview(widthDp = 320)
@Composable
internal fun CharactersScreenPreview() {
    NarutocardsTheme {
        CharactersScreen(characters = List(7) { sampleCharacter }, onCharacterClicked = { })
    }
}