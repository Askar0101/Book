package com.texnopos.uz.myapplicationbook.ui.category

import android.os.Bundle
import android.view.View
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import com.texnopos.uz.myapplicationbook.R
import com.texnopos.uz.myapplicationbook.ui.Settings
import com.texnopos.uz.myapplicationbook.data.DatabaseTheme
import com.texnopos.uz.myapplicationbook.data.ThemesDao
import com.texnopos.uz.myapplicationbook.ui.MainActivity
import kotlinx.android.synthetic.main.app_textview_toolbar.*
import kotlinx.android.synthetic.main.text_item.*

class TextThemesFragment : Fragment(R.layout.text_item) {
    lateinit var settings: Settings
    private lateinit var dao: ThemesDao
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().actionBar?.setTitle(R.string.text)

        val ThemesId = arguments?.getInt(ThemeFragment.THEMES_ID)
        dao = DatabaseTheme.getInstance(requireContext()).themesDao()
        val text2 = dao.getTextByThemeId(ThemesId!!)
      //  (requireActivity() as MainActivity).supportActionBar!!.title = "Texts"
        settings =
            Settings(this.requireContext())
        setTextSize()
        textView.text = HtmlCompat.fromHtml(text2.text, HtmlCompat.FROM_HTML_MODE_COMPACT)
        imageSizePulis?.setOnClickListener {
            settings.textSize = settings.textSize + 2f
            setTextSize()
        }
        imageSizeMinus?.setOnClickListener {
            settings.textSize = settings.textSize - 2f
            setTextSize()
        }
    }

    private fun setTextSize() {
        textView.textSize = settings.textSize
    }
}