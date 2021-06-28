package com.texnopos.uz.myapplicationbook.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.texnopos.uz.myapplicationbook.data.model.Category
import com.texnopos.uz.myapplicationbook.data.model.Text
import com.texnopos.uz.myapplicationbook.data.model.Theme


@Database(entities = [Theme::class, Category::class , Text::class], version = 2, exportSchema = false)
abstract class DatabaseTheme : RoomDatabase() {
    companion object {
        private lateinit var INSTANCE: DatabaseTheme
        fun getInstance(context: Context): DatabaseTheme {
            if (!Companion::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    DatabaseTheme::class.java,
                    "Allanazar Abdirenov.db"
                )
                    .createFromAsset("Allanazar Abdirenov.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }

    abstract fun themesDao(): ThemesDao
}