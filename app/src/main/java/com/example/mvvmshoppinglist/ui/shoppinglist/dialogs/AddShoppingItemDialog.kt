package com.example.mvvmshoppinglist.ui.shoppinglist.dialogs

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.mvvmshoppinglist.R
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

class AddShoppingItemDialog(context : Context, private var addDialogListener: AddDialogListener) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        tvAdd.setOnClickListener {

            val name = etName.text.toString()
            val amount = etAmount.text.toString()


            if(name.isEmpty()) {
                Toast.makeText(context,"Name cannot be empty!", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            try {
                amount.toInt()
            } catch (e : Throwable) {
                if(amount.isNotEmpty()) {
                    Toast.makeText(context,"Number is too high!", Toast.LENGTH_SHORT)
                        .show()
                    return@setOnClickListener
                }
            }

            if(amount.isEmpty()) {
                addDialogListener.onAddButtonClicked(ShoppingItem(name, 1,false))
            } else {
                addDialogListener.onAddButtonClicked(ShoppingItem(name, amount.toInt(),false))
            }

            Toast.makeText(context,"Item added!", Toast.LENGTH_SHORT).show()
            etName.text = null
            etAmount.text = null
            return@setOnClickListener
        }

        tvCancel.setOnClickListener {
            cancel()
        }
    }
}