package com.texnopos.uz.myapplicationbook.ui.category

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import com.texnopos.uz.myapplicationbook.R
import com.texnopos.uz.myapplicationbook.ui.Settings
import com.texnopos.uz.myapplicationbook.data.DatabaseTheme
import com.texnopos.uz.myapplicationbook.data.ThemesDao
import com.texnopos.uz.myapplicationbook.ui.home.HomeFragment
import kotlinx.android.synthetic.main.app_textview_toolbar.*
import kotlinx.android.synthetic.main.text_item.*

class
TextFragment : Fragment(R.layout.text_item) {
    private lateinit var dao: ThemesDao
    lateinit var settings: Settings
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoryId = arguments?.getInt(HomeFragment.CATEGORY_ID)
        dao = DatabaseTheme.getInstance(requireContext()).themesDao()
        val text = dao.getTextByCategoryId(categoryId!!)
        //textView.text = text.text
        settings =
            Settings(this.requireContext())
        textSize()
        textView.text = HtmlCompat.fromHtml(text.text, HtmlCompat.FROM_HTML_MODE_COMPACT)
        imageSizePulis.setOnClickListener {
            settings.textSize = settings.textSize + 2f
            textSize()
        }
        imageSizeMinus.setOnClickListener {
            settings.textSize = settings.textSize - 2f
            textSize()
        }

        imgFav.setOnClickListener {
            if (imgFav.setImageResource(R.drawable.ic_baseline_bookmark_24) != imgFav.setImageResource(
                    R.drawable.ic_baseline_bookmark_24
                )
            ) {
                imgFav.setImageResource(R.drawable.ic_baseline_bookmark_border_24)
            } else {
                imgFav.setImageResource(R.drawable.ic_baseline_bookmark_24)
            }
        }
    }

    fun textSize() {
        textView.textSize = settings.textSize
    }

}