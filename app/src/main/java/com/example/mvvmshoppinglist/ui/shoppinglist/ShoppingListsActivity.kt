package com.example.mvvmshoppinglist.ui.shoppinglist

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.mvvmshoppinglist.R
import com.example.mvvmshoppinglist.ui.shoppinglist.Fragments.FragmentAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class ShoppingListsActivity : FragmentActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentAdapter =
            FragmentAdapter(
                supportFragmentManager,
                lifecycle
            )

        viewPager2.adapter = fragmentAdapter
        TabLayoutMediator(
            tabLayout,
            viewPager2,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {
                    0 -> {
                        tab.text = "Current"
                        tab.setIcon(R.drawable.ic_list)
                    }
                    1 -> {
                        tab.text = "Archived"
                        tab.setIcon(R.drawable.ic_archive)
                    }
                }
            }).attach()

    }
}


