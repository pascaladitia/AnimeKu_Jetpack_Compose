package com.pascal.anime_ku.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FavoriteAnime")
data class Anime (

    @field:ColumnInfo(name = "Id")
    @field:PrimaryKey
    val id: Long,

    @field:ColumnInfo(name = "Name")
    val name: String,

    @field:ColumnInfo(name = "Power")
    val power: String,

    @field:ColumnInfo(name = "Seiyu")
    val seiyu: String,

    @field:ColumnInfo(name = "Gender")
    val gender: String,

    @field:ColumnInfo(name = "Type")
    val type: String,

    @field:ColumnInfo(name = "PhotoId")
    val photoId: Int,

    @field:ColumnInfo(name = "Detail")
    val detail: String,
)