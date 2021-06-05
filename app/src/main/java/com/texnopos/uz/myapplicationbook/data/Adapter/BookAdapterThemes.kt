package com.texnopos.uz.myapplicationbook.data.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.texnopos.uz.myapplicationbook.R
import com.texnopos.uz.myapplicationbook.data.model.Category
import com.texnopos.uz.myapplicationbook.data.model.Theme
import kotlinx.android.synthetic.main.item.view.*

class BookAdapterThemes : RecyclerView.Adapter<BookAdapterThemes.BookView>() {
    var model: List<Category> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class BookView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populeteModel(data: Category) {
            itemView.Textview.text = data.Catename

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookView {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return BookView(itemView)
    }

    var onItemClicked: (id: Int) -> Unit = {}
    override fun getItemCount(): Int = model.size
    override fun onBindViewHolder(holder: BookView, position: Int) {
        holder.populeteModel(model[position])
    }
}