package com.texnopos.uz.myapplicationbook.data

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.texnopos.uz.myapplicationbook.ui.home.CategoryAdapter
import com.texnopos.uz.myapplicationbook.data.model.Category
import com.texnopos.uz.myapplicationbook.data.model.Text
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.inner_item.view.*
import kotlinx.android.synthetic.main.text_item.view.*

class CategoryView(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //val myAdapter = CategoryAdapter()
        fun populetModel(category: Category, onItemClickeListener: (category: Category) -> Unit) {
        itemView.tvName.text = category.Catename
       // itemView.recyclerView1?.adapter = myAdapter
        itemView.setOnClickListener {
            onItemClickeListener.invoke(category)
        }
    }
}