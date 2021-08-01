package com.example.mvvmshoppinglist.ui.shoppinglist.ViewModels;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mvvmshoppinglist.ui.shoppinglist.Fragments.ArchivedListsFragment;
import com.example.mvvmshoppinglist.ui.shoppinglist.Fragments.CurrentListsFragment;


public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position)
        {
            case 1:
                return new ArchivedListsFragment();
        }
        return new CurrentListsFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
