package com.texnopos.uz.myapplicationbook.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categoty")
data class Category(
        @PrimaryKey val id: Int,
        @ColumnInfo(name = "name")
        val Catename: String,
        @ColumnInfo(name = "description")
        val description: String,
        @ColumnInfo(name = "season")
        val season: Int
) {
}