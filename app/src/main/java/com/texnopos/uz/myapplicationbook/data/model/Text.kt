package com.texnopos.uz.myapplicationbook.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "texts")
data class Text(
    @PrimaryKey val id:Int,
    @ColumnInfo(name = "text")
    val text:String,
    @ColumnInfo(name = "category_id")
    val category_id:Int,
    @ColumnInfo(name = "theme_id")
    val theme_id:Int
)
