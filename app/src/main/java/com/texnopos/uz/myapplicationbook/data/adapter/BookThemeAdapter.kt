package com.texnopos.uz.myapplicationbook.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.texnopos.uz.myapplicationbook.R
import com.texnopos.uz.myapplicationbook.data.BookView
import com.texnopos.uz.myapplicationbook.data.model.Category

class BookThemeAdapter : RecyclerView.Adapter<BookView>() {

    var model: List<Category> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookView {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.inner_item, parent, false)
        return BookView(itemView)
    }

   // var onItemClicked: () -> Unit = {}
   // fun onItemClickListener(onItemClicked: () -> Unit){
    //    this.onItemClicked = onItemClicked
   // }

    override fun getItemCount(): Int = model.size
    override fun onBindViewHolder(holder: BookView, position: Int) {
        holder.populetModel(model[position] )
    }
}