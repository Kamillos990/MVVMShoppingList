package com.example.mvvmshoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmshoppinglist.R
import com.example.mvvmshoppinglist.data.db.entities.ShoppingList
import com.example.mvvmshoppinglist.ui.shoppinglist.ShoppingListViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*
import kotlinx.android.synthetic.main.shopping_lists.view.*

class ShoppingListAdapter(
    var lists: List<ShoppingList>,
    private val listener: OnItemClickListener
): RecyclerView.Adapter<ShoppingListAdapter.ShoppingListViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_lists, parent, false)
        return ShoppingListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingListViewHolder, position: Int) {
        val curShoppingList =lists[position]

        holder.itemView.tvListName.text = curShoppingList.list_name


//        holder.itemView.ivDelete.setOnClickListener {
//            listViewModel.deleteItem(curShoppingList)
//        }
//
//        holder.itemView.ivPlus.setOnClickListener {
//            curShoppingList.amount++
//            listViewModel.upsertItem(curShoppingList)
//        }
//
//        holder.itemView.ivMinus.setOnClickListener {
//            if(curShoppingList.amount > 0) {
//                curShoppingList.amount--
//                listViewModel.upsertItem(curShoppingList)
//            }
//        }
    }






    override fun getItemCount(): Int {
        return lists.size
    }

    inner class ShoppingListViewHolder(listView: View): RecyclerView.ViewHolder(listView), View.OnClickListener
    {
        init{
            listView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
           val position = adapterPosition
            if(position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
}