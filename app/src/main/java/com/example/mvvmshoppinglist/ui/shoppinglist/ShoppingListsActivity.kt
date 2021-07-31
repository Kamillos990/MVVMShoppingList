package com.example.mvvmshoppinglist.ui.shoppinglist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.mvvmshoppinglist.R
import com.example.mvvmshoppinglist.data.db.ShoppingDatabase
import com.example.mvvmshoppinglist.data.db.entities.ShoppingList
import com.example.mvvmshoppinglist.data.repositories.ShoppingRepository
import com.example.mvvmshoppinglist.other.ShoppingListAdapter
import com.example.mvvmshoppinglist.ui.shoppinglist.ViewModels.FragmentAdapter
import com.example.mvvmshoppinglist.ui.shoppinglist.dialogs.CreateDialogListener
import com.example.mvvmshoppinglist.ui.shoppinglist.dialogs.CreateShoppingListDialog
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class ShoppingListsActivity : FragmentActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentAdapter = FragmentAdapter(supportFragmentManager, lifecycle)

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


