package com.pascal.anime_ku.ui.screen.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pascal.anime_ku.di.Injection
import com.pascal.anime_ku.ui.common.UIState
import com.pascal.anime_ku.ui.component.DetailContent
import com.pascal.anime_ku.ui.screen.ViewModelFactory

@Composable
fun DetailScreen(
    id: Long,
    showSnackbar: (String) -> Unit,
    detailViewModel: DetailViewModel = viewModel(factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))),
    navigateBack: () -> Unit
) {
    detailViewModel.animeDetail.collectAsState(initial = UIState.Loading).value.let { uiState ->
        when(uiState){
            is UIState.Loading -> {
                detailViewModel.getanimeById(id)
            }
            is UIState.Success -> {
                DetailContent(
                    anime = uiState.data.anime,
                    isFavorite = uiState.data.isFavorite,
                    addToFavorite = { anime ->
                        detailViewModel.addFavouriteUser(anime)
                        showSnackbar("Added to favorite")
                    },
                    deleteFromFavorite = { anime ->
                        detailViewModel.deleteFavouriteUser(anime.id)
                        showSnackbar("Deleted from favorite")
                    },
                    onBackClick = navigateBack
                )
            }
            is UIState.Error -> {}
        }
    }
}