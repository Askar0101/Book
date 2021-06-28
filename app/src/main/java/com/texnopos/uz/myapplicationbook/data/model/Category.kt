package com.texnopos.uz.myapplicationbook.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class Category(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name")
    val Catename: String,
    @ColumnInfo(name = "season")
    val season: Int,
    @ColumnInfo(name = "is_devides")
    var is_devides: Int
)