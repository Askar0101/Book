package com.texnopos.uz.myapplicationbook.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.texnopos.uz.myapplicationbook.R
import com.texnopos.uz.myapplicationbook.data.CategoryView
import com.texnopos.uz.myapplicationbook.data.model.Category

class CategoryAdapter : RecyclerView.Adapter<CategoryView>() {

    var model: List<Category> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onItemClicked: (category: Category) -> Unit = {}
    fun onItemClickListener(onItemClicked: (category: Category) -> Unit) {
        this.onItemClicked = onItemClicked
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryView {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.inner_item, parent, false)
        return CategoryView(itemView)
    }

    override fun getItemCount(): Int = model.size

    override fun onBindViewHolder(holder: CategoryView, position: Int) {
        holder.populetModel(model[position],onItemClicked)
    }
}