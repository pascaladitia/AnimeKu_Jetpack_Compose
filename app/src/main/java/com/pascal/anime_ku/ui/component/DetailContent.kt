package com.pascal.anime_ku.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pascal.anime_ku.model.Anime

@Composable
fun DetailContent(
    anime: Anime,
    isFavorite: Boolean,
    addToFavorite: (Anime) -> Unit,
    deleteFromFavorite: (Anime) -> Unit,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "nav_back",
            modifier = Modifier
                .padding(vertical = 16.dp)
                .clickable { onBackClick() }
        )
        Row {
            Box(modifier = Modifier.weight(1f)) {
                Image(
                    painter = painterResource(id = anime.photoId),
                    contentScale = ContentScale.Crop,
                    contentDescription = anime.name,
                    modifier = Modifier.size(300.dp)
                )
                if (isFavorite) {
                    IconButton(
                        onClick = {deleteFromFavorite(anime)},
                        modifier = Modifier.align(Alignment.TopEnd)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            tint = Color.Red,
                            contentDescription = "fav_button",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                } else {
                    IconButton(
                        onClick = { addToFavorite(anime) },
                        modifier = Modifier.align(Alignment.TopEnd)
                    ) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            tint = Color.Red,
                            contentDescription = "Favorite Button",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(text = "Name :\n${anime.name}")
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = "Power :\n${anime.power}")
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = "Seiyu :\n${anime.seiyu}")
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = "Gender :\n${anime.gender}")
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = "Type :\n${anime.type}")
                Spacer(modifier = Modifier.padding(5.dp))
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = anime.detail, textAlign = TextAlign.Justify)
    }
}