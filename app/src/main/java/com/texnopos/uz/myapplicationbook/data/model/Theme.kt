package com.texnopos.uz.myapplicationbook.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "themes")
data class Theme(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "text")
    val text: String,
    @ColumnInfo(name = "is-favorite")
    var favorite: Int,
    @ColumnInfo(name = "category-id")
    val category: Int
)