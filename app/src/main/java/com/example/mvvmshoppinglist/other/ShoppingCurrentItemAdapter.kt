package com.example.mvvmshoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmshoppinglist.R
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.example.mvvmshoppinglist.ui.shoppinglist.ShoppingItemViewModel
import kotlinx.android.synthetic.main.shopping_current_item.view.*


class ShoppingCurrentItemAdapter(
    var items: List<ShoppingItem>,
    private val itemViewModel: ShoppingItemViewModel
): RecyclerView.Adapter<ShoppingCurrentItemAdapter.ShoppingItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_current_item, parent, false)
        return ShoppingItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, position: Int) {
        val curShoppingItem = items[position]

        holder.itemView.tvName.text = curShoppingItem.name
        holder.itemView.tvAmount.text = "${curShoppingItem.amount}"

        holder.itemView.ivDelete.setOnClickListener {
            itemViewModel.deleteItem(curShoppingItem)
        }

        holder.itemView.ivPlus.setOnClickListener {
            curShoppingItem.amount++
            itemViewModel.upsertItem(curShoppingItem)
        }

        holder.itemView.ivMinus.setOnClickListener {
            if(curShoppingItem.amount > 0) {
                curShoppingItem.amount--
                itemViewModel.upsertItem(curShoppingItem)
            }
        }
    }

    inner class ShoppingItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}