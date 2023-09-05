package com.pascal.anime_ku.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pascal.anime_ku.data.Repository
import com.pascal.anime_ku.model.Anime
import com.pascal.anime_ku.ui.common.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: Repository) : ViewModel() {

    private val _animeDetail: MutableStateFlow<UIState<DetailState>> = MutableStateFlow(UIState.Loading)
    val animeDetail: StateFlow<UIState<DetailState>>
        get() = _animeDetail

    fun getanimeById(id: Long){
        viewModelScope.launch {
            repository.getFavoriteAnimeById(id).collect{
                _animeDetail.value = UIState.Loading
                _animeDetail.value = UIState.Success(DetailState(repository.getAnimeById(id), it!=null))
            }
        }
    }

    fun addFavouriteUser(anime: Anime){
        viewModelScope.launch {
            repository.addFavouriteAnime(anime)
        }
    }

    fun deleteFavouriteUser(id: Long){
        viewModelScope.launch {
            repository.deleteFavouriteAnime(id)
        }
    }
}