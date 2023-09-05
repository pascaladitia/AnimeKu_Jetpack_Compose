package com.pascal.anime_ku.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.pascal.anime_ku.ui.theme.AnimeKuTheme

@Composable
fun OptionMenu(
    navigateToAbout: () -> Unit,
    navigateToFavorite: () -> Unit,
    modifier: Modifier = Modifier
) {
   Row(modifier = modifier) {
       IconButton(onClick =  navigateToFavorite) {
           Icon(
               imageVector = Icons.Default.Favorite,
               tint = Color.White,
               contentDescription = "favorite_page"
           )
       }

       IconButton(onClick = navigateToAbout) {
           Icon(
               imageVector = Icons.Default.Person,
               tint = Color.White,
               contentDescription = "about_page"
           )
       }
   } 
}