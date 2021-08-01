package com.example.mvvmshoppinglist.ui.shoppinglist.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmshoppinglist.data.repositories.ShoppingRepository

class ShoppingListViewModelFactory(
    private val repository : ShoppingRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingListViewModel(repository) as T
    }

}