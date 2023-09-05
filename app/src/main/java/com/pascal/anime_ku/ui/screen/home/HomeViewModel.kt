package com.pascal.anime_ku.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.pascal.anime_ku.data.Repository
import com.pascal.anime_ku.model.Anime
import com.pascal.anime_ku.ui.common.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(private val repository: Repository) : ViewModel() {

    private val _groupedAnime: MutableStateFlow<UIState<Map<String, List<Anime>>>> = MutableStateFlow(UIState.Loading)
    val groupedAnime: StateFlow<UIState<Map<String, List<Anime>>>>
    get() = _groupedAnime

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query


    fun getAllAnime(){
        _groupedAnime.value = UIState.Loading
        _groupedAnime.value = UIState.Success(repository.getAllAnime().sortedBy { it.name }.groupBy { it.type })
    }

    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedAnime.value =  UIState.Success(repository.searchAnime(newQuery).sortedBy { it.name }.groupBy { it.type })
    }
}

