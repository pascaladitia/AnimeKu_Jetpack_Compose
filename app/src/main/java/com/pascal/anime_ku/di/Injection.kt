package com.pascal.anime_ku.di

import android.content.Context
import com.pascal.anime_ku.data.Repository
import com.pascal.anime_ku.data.local.room.FavoriteDatabase

object Injection {
    fun provideRepository(context: Context): Repository {
        val database = FavoriteDatabase.getInstance(context)
        val dao = database.favoriteDao()
        return Repository.getInstance(dao)
    }
}