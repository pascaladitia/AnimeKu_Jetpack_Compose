package com.pascal.anime_ku.ui.screen.favorite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pascal.anime_ku.di.Injection
import com.pascal.anime_ku.ui.common.UIState
import com.pascal.anime_ku.ui.component.FavoriteContent
import com.pascal.anime_ku.ui.screen.ViewModelFactory

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    favoriteViewModel: FavoriteViewModel = viewModel(factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))),
    navigateToDetail: (Long) -> Unit,
    navigateBack: () -> Unit
) {
    favoriteViewModel.favoriteCharacters.collectAsState(initial = UIState.Loading).value.let { uiState ->
        when(uiState){
            is UIState.Loading -> {
                favoriteViewModel.getFavouriteUser()
            }
            is UIState.Success -> {
                FavoriteContent(
                    modifier = modifier,
                    favoriteAnime = uiState.data,
                    navigateToDetail = navigateToDetail,
                    onBackClick = navigateBack
                )
            }
            is UIState.Error -> {}
        }
    }

}