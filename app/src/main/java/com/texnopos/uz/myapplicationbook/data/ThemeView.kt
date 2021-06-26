package com.texnopos.uz.myapplicationbook.data

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.texnopos.uz.myapplicationbook.data.model.Theme
import kotlinx.android.synthetic.main.inner_item.view.*

class ThemeView(itemView:View):RecyclerView.ViewHolder(itemView) {
    fun themeModel(theme: Theme,onItemClicked: (theme:Theme) -> Unit){
        itemView.tvName.text=theme.name
        itemView.setOnClickListener {
            onItemClicked.invoke(theme)
        }
    }
}