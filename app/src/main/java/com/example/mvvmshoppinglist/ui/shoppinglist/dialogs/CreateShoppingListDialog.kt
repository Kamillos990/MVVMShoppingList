package com.example.mvvmshoppinglist.ui.shoppinglist.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.DialogFragment
import com.example.mvvmshoppinglist.R
import com.example.mvvmshoppinglist.data.db.entities.ShoppingList
import kotlinx.android.synthetic.main.dialog_add_shopping_item.etName
import kotlinx.android.synthetic.main.dialog_create_shopping_list.*

class CreateShoppingListDialog(private var createDialogListener: CreateDialogListener) : DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage("walimy")
            builder.create()


        }?: throw IllegalStateException("Activity cannot be null")
    }

//        override fun onCreate(savedInstanceState: Bundle?) {
//            super.onCreate(savedInstanceState)
//            setContentView(R.layout.dialog_create_shopping_list)
//
//            tvCreate.setOnClickListener {
//
//                val name = tvCreateList.text.toString()
//
//
//                if(name.isEmpty()) {
//                    Toast.makeText(context,"Name cannot be empty!", Toast.LENGTH_SHORT)
//                        .show()
//                    return@setOnClickListener
//                }
//                createDialogListener.onCreateButtonClicked(ShoppingList(name, false))
//
//                Toast.makeText(context,"Item added!", Toast.LENGTH_SHORT).show()
//                etName.text = null
//
//                return@setOnClickListener
//            }
//
//            tvCancelList.setOnClickListener {
//                cancel()
//            }
//        }
    }
