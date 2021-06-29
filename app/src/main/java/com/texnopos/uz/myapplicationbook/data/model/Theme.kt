package com.texnopos.uz.myapplicationbook.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "themes")
data class Theme(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "category_id")
    val category: Int,

    @ColumnInfo(name = "is_favorite")
    var favorite: Int
)