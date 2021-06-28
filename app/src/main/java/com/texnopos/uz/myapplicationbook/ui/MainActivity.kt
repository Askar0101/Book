package com.texnopos.uz.myapplicationbook.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.texnopos.uz.myapplicationbook.R
import com.texnopos.uz.myapplicationbook.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.myToolbar))
        val mFragment = HomeFragment()
            // val save = SectionFragment()
        val search = SearchFragment()
        fragment(mFragment)
        setTitle(R.string.text)
        supportFragmentManager.beginTransaction().replace(R.id.frame, HomeFragment())
            .addToBackStack("HomeFragment").commit()
        BottomNavigatinView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_Home -> {
                    supportFragmentManager.popBackStackImmediate("HomeFragment",0)
                    supportFragmentManager.popBackStackImmediate()
                    fragment(mFragment)
                }
                R.id.ic_Save -> {
                     // fragment(save)
                }
                R.id.ic_services -> {
                   fragment(search)
                }
            }
            true
        }
    }

    fun fragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount === 1) {
            finish()
        } else {
            supportFragmentManager.popBackStackImmediate()
        }
    }

}