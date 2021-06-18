package com.texnopos.uz.myapplicationbook.data.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.texnopos.uz.myapplicationbook.R
import com.texnopos.uz.myapplicationbook.data.adapter.BookThemeAdapter
import com.texnopos.uz.myapplicationbook.data.database.DatabaseTheme
import com.texnopos.uz.myapplicationbook.data.dao.Themes
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.inner_item.*

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val adapter1 = BookThemeAdapter()
    private val adapter2 = BookThemeAdapter()
    private lateinit var dao: Themes
    private val categoryFragment = CategoryFragment()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView1.adapter = adapter1
        recyclerView2.adapter = adapter2
        season1.setOnClickListener {
            if (recyclerView1.visibility==View.GONE){
                recyclerView1.visibility=View.VISIBLE
            }else{
                recyclerView1.visibility=View.GONE
            }
        }
        season2.setOnClickListener {
            if (recyclerView2.visibility==View.GONE){
                recyclerView2.visibility=View.VISIBLE
            }else {
                recyclerView2.visibility=View.GONE
            }
        }

        //     adapter1.onItemClickListener {
        //       fragmentManager?.beginTransaction()?.replace(R.id.frame, categoryFragment)?.commit()
        //  dao.getTextById(1)
        // }

        // adapter2.onItemClickListener {
        //       fragmentManager?.beginTransaction()?.replace(R.id.frame, categoryFragment)?.commit()

        // }

        dao = DatabaseTheme.getInstance(requireContext()).themesDao()
        setData()
    }

    private fun setData() {
        adapter1.model = dao.getAllCategory(1)
        adapter2.model = dao.getAllCategory(2)
    }

}