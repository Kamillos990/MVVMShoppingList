package com.example.mvvmshoppinglist.ui.shoppinglist.dialogs

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.mvvmshoppinglist.R
import com.example.mvvmshoppinglist.data.db.entities.ShoppingList
import kotlinx.android.synthetic.main.dialog_add_shopping_item.etName
import kotlinx.android.synthetic.main.dialog_create_shopping_list.*

class CreateShoppingListDialog(context : Context, private var createDialogListener: CreateDialogListener) : AppCompatDialog(context) {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.dialog_create_shopping_list)

            tvCreate.setOnClickListener {

                val name = tvCreateList.text.toString()


                if(name.isEmpty()) {
                    Toast.makeText(context,"Name cannot be empty!", Toast.LENGTH_SHORT)
                        .show()
                    return@setOnClickListener
                }
                createDialogListener.onCreateButtonClicked(ShoppingList(name, false))

                Toast.makeText(context,"Item added!", Toast.LENGTH_SHORT).show()
                etName.text = null

                return@setOnClickListener
            }

            tvCancelList.setOnClickListener {
                cancel()
            }
        }
    }
