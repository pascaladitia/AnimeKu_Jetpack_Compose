package com.pascal.anime_ku.ui.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pascal.anime_ku.data.Repository
import com.pascal.anime_ku.model.Anime
import com.pascal.anime_ku.ui.common.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavoriteViewModel(private val repository: Repository) : ViewModel() {

    private val _favoriteCharacters: MutableStateFlow<UIState<List<Anime>>> = MutableStateFlow(UIState.Loading)
    val favoriteCharacters: StateFlow<UIState<List<Anime>>>
        get() = _favoriteCharacters

    fun getFavouriteUser(){
        viewModelScope.launch{
            _favoriteCharacters.value = UIState.Loading
            repository.getFavouriteAnime().collect{_favoriteCharacters.value = UIState.Success(it)}
        }
    }
}