package com.texnopos.uz.myapplicationbook.data.Fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.texnopos.uz.myapplicationbook.R
import com.texnopos.uz.myapplicationbook.data.Adapter.BookAdapterThemes
import com.texnopos.uz.myapplicationbook.data.DataBes.DataBesThemes
import com.texnopos.uz.myapplicationbook.data.dao.Themes
import kotlinx.android.synthetic.main.activity_item.*

class MyFragment : Fragment(R.layout.activity_item) {
    private val adapter = BookAdapterThemes()
    private lateinit var dao: Themes
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        adapter.onItemClicked = {

        }
        dao = DataBesThemes.getInstance(requireContext()).themesDao()
        setData()
    }

    private fun setData() {
        adapter.model = dao.getAllCategory(1)    }

}