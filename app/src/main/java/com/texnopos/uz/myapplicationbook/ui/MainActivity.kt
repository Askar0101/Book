package com.texnopos.uz.myapplicationbook.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.texnopos.uz.myapplicationbook.R
import com.texnopos.uz.myapplicationbook.ui.about.AboutFragment
import com.texnopos.uz.myapplicationbook.ui.favorite.FavouriteFragment
import com.texnopos.uz.myapplicationbook.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.myToolbar))
        val mFragment = HomeFragment()
            // val save = SectionFragment()
        val search = AboutFragment()
        fragment(mFragment)
        setTitle(R.string.text)
        supportFragmentManager.beginTransaction().replace(R.id.frame, HomeFragment())
            .addToBackStack("HomeFragment").commit()

        bottomNavView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.icon_home -> {
                    supportFragmentManager.popBackStackImmediate("HomeFragment",0)
                    supportFragmentManager.popBackStackImmediate()
                    fragment(mFragment)
                }
                R.id.icon_favourite -> {
                    val favourite = FavouriteFragment()
                    fragment(favourite)
                }
                R.id.ic_about -> {
                    val aboutFragment = AboutFragment()
                    fragment(aboutFragment)
                }
            }
            true
        }
    }

    private fun fragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            supportFragmentManager.popBackStackImmediate()
        }
    }

}