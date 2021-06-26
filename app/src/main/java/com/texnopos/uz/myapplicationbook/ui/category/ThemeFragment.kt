package com.texnopos.uz.myapplicationbook.ui.category

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.texnopos.uz.myapplicationbook.R
import com.texnopos.uz.myapplicationbook.data.DatabaseTheme
import com.texnopos.uz.myapplicationbook.data.ThemesDao
import com.texnopos.uz.myapplicationbook.ui.home.HomeFragment
import com.texnopos.uz.myapplicationbook.ui.home.ThemesAdapter
import kotlinx.android.synthetic.main.inner_theme.*

class ThemeFragment : Fragment(R.layout.inner_theme) {
    private val adapterTheme1 = ThemesAdapter()
    private val adapterTheme2 = ThemesAdapter()
    lateinit var dao: ThemesDao

    companion object {
        const val THEMES_ID = "id"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerTheme.adapter = adapterTheme1
        recyclerTheme.adapter = adapterTheme2
        val categoryId = arguments?.getInt(HomeFragment.CATEGORY_ID)
        dao = DatabaseTheme.getInstance(requireContext()).themesDao()
        val themes = dao.getThemeByCategoryId(categoryId!!)
        setData(categoryId)
        adapterTheme1.onItemClickListenerTheme {
            val mFragment = TextThemesFragment()
            val mBundle = Bundle()
            mBundle.putInt(THEMES_ID, it.id)
            mFragment.arguments = mBundle
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frame, mFragment).addToBackStack("HomeFragment").commit()
        }
        adapterTheme2.onItemClickListenerTheme {
            val mFragment = TextThemesFragment()
            val mBundle = Bundle()
            mBundle.putInt(THEMES_ID, it.id)
            mFragment.arguments = mBundle
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frame, mFragment).addToBackStack("HomeFragment").commit()
        }
    }

    fun setData(categoryId: Int) {
        adapterTheme1.model = dao.getThemeByCategoryId(categoryId)
        adapterTheme2.model = dao.getThemeByCategoryId(categoryId)
    }
}