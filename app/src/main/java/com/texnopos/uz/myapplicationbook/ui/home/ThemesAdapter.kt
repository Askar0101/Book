package com.texnopos.uz.myapplicationbook.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.texnopos.uz.myapplicationbook.R
import com.texnopos.uz.myapplicationbook.data.ThemeView
import com.texnopos.uz.myapplicationbook.data.model.Theme

class ThemesAdapter : RecyclerView.Adapter<ThemeView>() {
    var model: List<Theme> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onItemClickedTheme: (themes:Theme) -> Unit = {}
    fun onItemClickListenerTheme(onItemClicked: (theme:Theme) -> Unit) {
        this.onItemClickedTheme = onItemClicked
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThemeView {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.inner_item, parent, false)
        return ThemeView(itemView)
    }

    override fun getItemCount(): Int = model.size

    override fun onBindViewHolder(holder: ThemeView, position: Int) {
        holder.themeModel(model[position],onItemClickedTheme)
    }
}