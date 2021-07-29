package com.example.mvvmshoppinglist.ui.shoppinglist.dialogs

import com.example.mvvmshoppinglist.data.db.entities.ShoppingList

interface CreateDialogListener {
    fun onCreateButtonClicked(list: ShoppingList)
}
