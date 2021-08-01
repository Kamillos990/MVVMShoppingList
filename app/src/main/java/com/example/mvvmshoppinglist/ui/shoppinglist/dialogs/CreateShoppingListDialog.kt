package com.example.mvvmshoppinglist.ui.shoppinglist.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.DialogFragment
import com.example.mvvmshoppinglist.R
import com.example.mvvmshoppinglist.data.db.entities.ShoppingList
import kotlinx.android.synthetic.main.dialog_add_shopping_item.etName
import kotlinx.android.synthetic.main.dialog_create_shopping_list.*
import kotlinx.android.synthetic.main.dialog_create_shopping_list.view.*

class CreateShoppingListDialog(private var createDialogListener: CreateDialogListener) : DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val view: View = inflater.inflate(R.layout.dialog_create_shopping_list, null)
            builder.setView(view)
                .setPositiveButton("Create", DialogInterface.OnClickListener { dialog, id ->
                    val name = view.etName.text.toString()


                if(name.isEmpty()) {
                    Toast.makeText(context,"Name cannot be empty!", Toast.LENGTH_SHORT)
                        .show()
                }
                createDialogListener.onCreateButtonClicked(ShoppingList(name, false))

                Toast.makeText(context,"Item added!", Toast.LENGTH_SHORT).show()
                view.etName.text = null
                })

                .setNegativeButton("Cancel", DialogInterface.OnClickListener{dialog, id ->
                    getDialog()?.cancel()
                })
            builder.create()


        }?: throw IllegalStateException("Activity cannot be null")
    }


    }
