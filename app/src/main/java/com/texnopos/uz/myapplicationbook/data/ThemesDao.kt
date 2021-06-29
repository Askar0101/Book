package com.texnopos.uz.myapplicationbook.data

import androidx.room.Dao
import androidx.room.Query
import com.texnopos.uz.myapplicationbook.data.model.Category
import com.texnopos.uz.myapplicationbook.data.model.Text
import com.texnopos.uz.myapplicationbook.data.model.Theme
import java.util.*

@Dao
interface ThemesDao {
    @Query("SELECT * FROM themes")
    fun getAllThemes(): List<Theme>

    @Query("SELECT * FROM category WHERE season=:season")
    fun getAllCategory(season: Int): List<Category>

    @Query("SELECT * FROM texts WHERE id=:id")
    fun getAllText(id: Int): List<Text>

    @Query("SELECT * FROM themes WHERE category_id=:categoryId")
    fun getThemeByCategoryId(categoryId: Int): List<Theme>

    @Query("SELECT * FROM texts WHERE category_id=:categoryId")
    fun getTextByCategoryId(categoryId: Int): Text

    @Query("SELECT * FROM texts WHERE theme_id=:themeId")
    fun getTextByThemeId(themeId: Int): Text

    @Query("SELECT * FROM themes WHERE is_favorite = 1")
    fun getFavorite(): Theme
}