package com.pascal.anime_ku.data

import com.pascal.anime_ku.data.local.room.FavoriteDao
import com.pascal.anime_ku.model.Anime
import com.pascal.anime_ku.model.SampleDataSource
import kotlinx.coroutines.flow.Flow

class Repository private constructor(private val favoriteDao: FavoriteDao){

    fun getAllAnime(): List<Anime> {
        return SampleDataSource.dummyAnimes
    }

    fun getAnimeById(id: Long): Anime {
        return SampleDataSource.dummyAnimes.first {
            it.id == id
        }
    }

    fun searchAnime(query: String): List<Anime>{
        return SampleDataSource.dummyAnimes.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }

    fun getFavouriteAnime(): Flow<List<Anime>> {
        return favoriteDao.getAllFavoriteAnime()
    }

    suspend fun addFavouriteAnime(anime: Anime): Long{
        return favoriteDao.addFavouriteAnime(anime)
    }

    suspend fun deleteFavouriteAnime(id: Long): Int{
        return favoriteDao.deleteFavouriteAnime(id)
    }

    fun getFavoriteAnimeById(id: Long): Flow<Anime> = favoriteDao.getFavoriteAnimeById(id)

    companion object {
        @Volatile
        private var instance: Repository? = null
        fun getInstance(
            favoriteDao: FavoriteDao,
        ): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(favoriteDao)
            }.also { instance = it }
    }
}