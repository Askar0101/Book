package com.texnopos.uz.myapplicationbook.data.DataBes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.texnopos.uz.myapplicationbook.BuildConfig.VERSION_CODE
import com.texnopos.uz.myapplicationbook.data.dao.Themes
import com.texnopos.uz.myapplicationbook.data.model.Category
import com.texnopos.uz.myapplicationbook.data.model.Theme


@Database(entities = [Theme::class,Category::class], version = VERSION_CODE, exportSchema = false)
abstract class DataBesThemes : RoomDatabase() {
    companion object {
        private lateinit var INSTANCE: DataBesThemes
        fun getInstance(context: Context): DataBesThemes {
            if (!Companion::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(
                        context,
                        DataBesThemes::class.java,
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