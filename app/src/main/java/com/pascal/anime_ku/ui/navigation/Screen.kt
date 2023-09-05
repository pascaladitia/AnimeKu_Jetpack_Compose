package com.pascal.anime_ku.ui.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object About: Screen("about")
    object Favorite: Screen("favorite")
    object Detail: Screen("home/{id}") {
        fun createRout(id: Long) = "home/$id"
    }
}
