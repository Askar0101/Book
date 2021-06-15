package com.texnopos.uz.myapplicationbook.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.texnopos.uz.myapplicationbook.BuildConfig.VERSION_CODE
import com.texnopos.uz.myapplicationbook.data.dao.Themes
import com.texnopos.uz.myapplicationbook.data.model.Category
import com.texnopos.uz.myapplicationbook.data.model.Theme


@Database(entities = [Theme::class, Category::class], version = 1, exportSchema = false)
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

    abstract fun themesDao(): Themes
}