package com.pascal.anime_ku

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pascal.anime_ku.ui.navigation.Screen
import com.pascal.anime_ku.ui.screen.about.AboutScreen
import com.pascal.anime_ku.ui.screen.detail.DetailScreen
import com.pascal.anime_ku.ui.screen.favorite.FavoriteScreen
import com.pascal.anime_ku.ui.screen.home.HomeScreen
import com.pascal.anime_ku.ui.theme.AnimeKuTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimeApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = modifier,
        snackbarHost = { SnackbarHost(hostState = snackbarHostState)}
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToAbout = { navController.navigate(Screen.About.route) },
                    navigateToDetail = { id -> navController.navigate(Screen.Detail.createRout(id))},
                    navigateToFavorite = { navController.navigate(Screen.Favorite.route)}
                )
            }
            composable(
                route = Screen.Detail.route,
                arguments = listOf(navArgument("id"){type = NavType.LongType})
            ){
                val id = it.arguments?.getLong("id") ?: -1L
                DetailScreen(
                    id = id,
                    showSnackbar = {message -> scope.launch { snackbarHostState.showSnackbar(message = message) }},
                    navigateBack = { navController.navigateUp() }
                )
            }
            composable(Screen.About.route){
                AboutScreen(navigateBack = { navController.navigateUp() })
            }
            composable(Screen.Favorite.route){
                FavoriteScreen(
                    navigateToDetail = { id -> navController.navigate(Screen.Detail.createRout(id)) },
                    navigateBack = { navController.navigateUp() }
                )
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun AnimeAppPreview() {
    AnimeKuTheme() {
        AnimeApp()
    }
}