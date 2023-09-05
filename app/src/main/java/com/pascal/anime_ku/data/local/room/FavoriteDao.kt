package com.pascal.anime_ku.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pascal.anime_ku.model.Anime
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM FavoriteAnime")
    fun getAllFavoriteAnime(): Flow<List<Anime>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavouriteAnime(Anime: Anime): Long

    @Query("DELETE FROM FavoriteAnime WHERE id = :id")
    suspend fun deleteFavouriteAnime(id: Long): Int

    @Query("SELECT * FROM FavoriteAnime WHERE id = :id")
    fun getFavoriteAnimeById(id: Long): Flow<Anime>

}