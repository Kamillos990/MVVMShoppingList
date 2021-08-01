package com.example.mvvmshoppinglist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmshoppinglist.R
import com.example.mvvmshoppinglist.data.db.entities.ShoppingList
import com.example.mvvmshoppinglist.ui.shoppinglist.ViewModels.ShoppingListViewModel
import kotlinx.android.synthetic.main.shopping_current_lists.view.*

class ShoppingCurrentListsAdapter(
    var lists: List<ShoppingList>,
    private val listViewModel: ShoppingListViewModel,
    private val listener: OnItemClickListener
): RecyclerView.Adapter<ShoppingCurrentListsAdapter.ShoppingListViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_current_lists, parent, false)
        return ShoppingListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingListViewHolder, position: Int) {
        val curShoppingList =lists[position]

        holder.itemView.tvListName.text = curShoppingList.list_name
        holder.itemView.btArchive.setOnClickListener {
            curShoppingList.archive = true
            listViewModel.upsertList(curShoppingList)
        }


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