package com.pascal.anime_ku.ui.screen.detail

import com.pascal.anime_ku.model.Anime

data class DetailState(
    val anime: Anime,
    val isFavorite: Boolean
)