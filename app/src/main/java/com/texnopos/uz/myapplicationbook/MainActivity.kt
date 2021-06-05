package com.texnopos.uz.myapplicationbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.texnopos.uz.myapplicationbook.data.Fragment.MyFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragDom = MyFragment()
        fragment(fragDom)
        BottomNavigatinView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_Home -> fragment(fragDom)
            }
            true
        }
    }

    fun fragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
    }

}