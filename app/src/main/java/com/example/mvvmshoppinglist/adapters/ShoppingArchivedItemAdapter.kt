package com.example.mvvmshoppinglist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmshoppinglist.R
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.example.mvvmshoppinglist.ui.shoppinglist.ViewModels.ShoppingItemViewModel
import kotlinx.android.synthetic.main.shopping_archived_item.view.*


class ShoppingArchivedItemAdapter(
    var items: List<ShoppingItem>,
    private val itemViewModel: ShoppingItemViewModel
): RecyclerView.Adapter<ShoppingArchivedItemAdapter.ShoppingItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_archived_item, parent, false)
        return ShoppingItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, position: Int) {
        val curShoppingItem = items[position]

        holder.itemView.tvName.text = curShoppingItem.name
        holder.itemView.tvAmount.text = "${curShoppingItem.amount}"

    }

    inner class ShoppingItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}