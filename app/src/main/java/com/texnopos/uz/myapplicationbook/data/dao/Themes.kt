package com.texnopos.uz.myapplicationbook.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.texnopos.uz.myapplicationbook.data.model.Category
import com.texnopos.uz.myapplicationbook.data.model.Theme

@Dao
interface Themes {
    @Query("SELECT * FROM themes")
    fun getAllThemes(): List<Theme>

    @Query("SELECT * FROM categoty where season=:season")
    fun getAllCategory(season: Int): List<Category>

    // @Query("SELECT * FROM categoty WHERE id=:id")
    //fun getTextById(id: Int)
}