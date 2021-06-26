package com.texnopos.uz.myapplicationbook.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.texnopos.uz.myapplicationbook.R
import com.texnopos.uz.myapplicationbook.data.DatabaseTheme
import com.texnopos.uz.myapplicationbook.data.ThemesDao
import com.texnopos.uz.myapplicationbook.ui.category.CategoryFragment
import com.texnopos.uz.myapplicationbook.ui.category.TextFragment
import com.texnopos.uz.myapplicationbook.ui.category.ThemeFragment
import kotlinx.android.synthetic.main.app_toolbar.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment(R.layout.fragment_home) {
    companion object {
        const val CATEGORY_ID = "id"
        const val MAGLIWMAT_ID = "id"
    }

    private val adapter1 =
        CategoryAdapter()
    private val adapter2 =
        CategoryAdapter()
    private lateinit var dao: ThemesDao
    private val categoryFragment =
        CategoryFragment()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView1.adapter = adapter1
        recyclerView2.adapter = adapter2
        season1.setOnClickListener {
            if (recyclerView1.visibility == View.GONE) {
                recyclerView1.visibility = View.VISIBLE
            } else {
                recyclerView1.visibility = View.GONE
            }
        }
        season2.setOnClickListener {
            if (recyclerView2.visibility == View.GONE) {
                recyclerView2.visibility = View.VISIBLE
            } else {
                recyclerView2.visibility = View.GONE
            }
        }

        adapter1.onItemClickListener {
            if (it.is_devides == 1) {
                val mFragment =
                    ThemeFragment()
                val mbundle = Bundle()
                mbundle.putInt(CATEGORY_ID, it.id)
                mFragment.arguments = mbundle
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, mFragment).addToBackStack("HomeFragment").commit()
                //todo Usi jerde ThemeFragment ashasan, bundle da it.id di berip jiberiwin kerek
            } else {
                val mFragment =
                    TextFragment()
                val mbundle = Bundle()
                mbundle.putInt(CATEGORY_ID, it.id)
                mFragment.arguments = mbundle
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, mFragment).addToBackStack("HomeFragment").commit()
                //todo Usi jerde TextFragment ashasan, bundle da it.id di berip jiberiwin kerek
            }
        }

        adapter2.onItemClickListener {
            if (it.is_devides == 1) {
                val mFragment = ThemeFragment()
                val mbundle = Bundle()
                mbundle.putInt(CATEGORY_ID, it.id)
                mFragment.arguments = mbundle
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, mFragment).addToBackStack("HomeFragment").commit()
                //todo Usi jerde ThemeFragment ashasan, bundle da it.id di berip jiberiwin kerek
            } else {
                val mFragment = TextFragment()
                val mbundle = Bundle()
                mbundle.putInt(CATEGORY_ID, it.id)
                mFragment.arguments = mbundle
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, mFragment).addToBackStack("HomeFragment").commit()
                //todo Usi jerde TextFragment ashasan, bundle da it.id di berip jiberiwin kerek
            }
        }
        // val id=requireArguments().getInt(MainActivity.TYPE_ID)
        dao = DatabaseTheme.getInstance(requireContext()).themesDao()
        setData()
    }

    private fun setData() {
        adapter1.model = dao.getAllCategory(1)
        adapter2.model = dao.getAllCategory(2)
    }

}