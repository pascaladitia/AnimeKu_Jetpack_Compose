package com.pascal.anime_ku.ui.screen.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pascal.anime_ku.di.Injection
import com.pascal.anime_ku.ui.common.UIState
import com.pascal.anime_ku.ui.component.HomeContent
import com.pascal.anime_ku.ui.screen.ViewModelFactory

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = viewModel(factory = ViewModelFactory(Injection.provideRepository(
        LocalContext.current))),
    navigateToAbout: () -> Unit,
    navigateToDetail: (Long) -> Unit,
    navigateToFavorite:() -> Unit
) {
    val query by homeViewModel.query
    homeViewModel.groupedAnime.collectAsState(initial = UIState.Loading).value.let { uiState ->
        when(uiState) {
            is UIState.Loading -> {
                homeViewModel.getAllAnime()
            }
            is UIState.Success -> {
                HomeContent(
                    groupAnime = uiState.data,
                    query = query,
                    onQueryChange = homeViewModel::search,
                    navigateToAbout = navigateToAbout,
                    navigateToDetail = navigateToDetail,
                    navigateToFavorite = navigateToFavorite,
                    modifier = modifier
                )
            }
            is UIState.Error -> {}
        }
    }
}