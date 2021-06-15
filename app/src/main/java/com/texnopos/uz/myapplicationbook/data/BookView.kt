package com.texnopos.uz.myapplicationbook.data

import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.texnopos.uz.myapplicationbook.data.adapter.BookThemeAdapter
import com.texnopos.uz.myapplicationbook.data.model.Category
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.inner_item.view.*

class BookView(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val myAdapter = BookThemeAdapter()
    fun populetModel(category: Category) {
        itemView.tvName.text = category.Catename
        itemView.recyclerView1?.adapter = myAdapter
        itemView.setOnClickListener {
            //onItemClickListener.invoke()
        }
    }
}