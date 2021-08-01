package com.example.mvvmshoppinglist.ui.shoppinglist.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmshoppinglist.R
import com.example.mvvmshoppinglist.data.db.ShoppingDatabase
import com.example.mvvmshoppinglist.data.db.entities.ShoppingList
import com.example.mvvmshoppinglist.data.repositories.ShoppingRepository
import com.example.mvvmshoppinglist.adapters.ShoppingArchivedListsAdapter
import com.example.mvvmshoppinglist.ui.shoppinglist.ShoppingArchivedItemActivity
import com.example.mvvmshoppinglist.ui.shoppinglist.ViewModels.ShoppingListViewModel
import com.example.mvvmshoppinglist.ui.shoppinglist.ViewModels.ShoppingListViewModelFactory
import kotlinx.android.synthetic.main.fragment_archived_lists.*


class ArchivedListsFragment : Fragment() ,ShoppingArchivedListsAdapter.OnItemClickListener {
    lateinit var lists : List<ShoppingList>
    lateinit var v: View



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_archived_lists, container, false)


        return  v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = ShoppingDatabase(activity?.applicationContext!!)
        val repository = ShoppingRepository(database)
        val factory = ShoppingListViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory).get(ShoppingListViewModel::class.java)

        val adapter = ShoppingArchivedListsAdapter(listOf(), viewModel,this )

        rvShoppingListsArchived.layoutManager = LinearLayoutManager(activity?.applicationContext!!)
        rvShoppingListsArchived.adapter = adapter
        var itemDecoration = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
        ResourcesCompat.getDrawable(requireActivity().resources, R.drawable.recycler_view_divider,null)
            ?.let { itemDecoration.setDrawable(it) }

        rvShoppingListsArchived.addItemDecoration(itemDecoration)


        viewModel.getArchivedShoppingLists().observe(viewLifecycleOwner, Observer {
            adapter.lists = it
            adapter.notifyDataSetChanged()
            this.lists = it
        })


    }

    override fun onItemClick(position: Int) {
        val intent = Intent(activity?.applicationContext!!, ShoppingArchivedItemActivity::class.java).apply {
            putExtra(getString(R.string.list_id), lists[position].id)
            putExtra(getString(R.string.list_name), lists[position].list_name)

        }
        startActivity(intent)

    }

    companion object {

        fun newInstance() : CurrentListsFragment=
            CurrentListsFragment()
    }
}