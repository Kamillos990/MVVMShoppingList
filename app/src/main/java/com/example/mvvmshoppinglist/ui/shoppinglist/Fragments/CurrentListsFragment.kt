package com.example.mvvmshoppinglist.ui.shoppinglist.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmshoppinglist.R
import com.example.mvvmshoppinglist.data.db.ShoppingDatabase
import com.example.mvvmshoppinglist.data.db.entities.ShoppingList
import com.example.mvvmshoppinglist.data.repositories.ShoppingRepository
import com.example.mvvmshoppinglist.other.ShoppingCurrentListsAdapter
import com.example.mvvmshoppinglist.ui.shoppinglist.ShoppingCurrentItemActivity
import com.example.mvvmshoppinglist.ui.shoppinglist.ShoppingListViewModel
import com.example.mvvmshoppinglist.ui.shoppinglist.ShoppingListViewModelFactory
import com.example.mvvmshoppinglist.ui.shoppinglist.dialogs.CreateDialogListener
import com.example.mvvmshoppinglist.ui.shoppinglist.dialogs.CreateShoppingListDialog
import kotlinx.android.synthetic.main.fragment_current_lists.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CurrentListsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CurrentListsFragment : Fragment(), ShoppingCurrentListsAdapter.OnItemClickListener {

    lateinit var lists : List<ShoppingList>
    lateinit var v: View



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
//
//    override fun onAttach(activity: Activity)
//    {
//        super.onAttach(activity)
//
//
//    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       v = inflater.inflate(R.layout.fragment_current_lists, container, false)


        return  v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = ShoppingDatabase(activity?.applicationContext!!)
        val repository = ShoppingRepository(database)
        val factory = ShoppingListViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory).get(ShoppingListViewModel::class.java)

        val adapter = ShoppingCurrentListsAdapter(listOf(), viewModel, this)

        rvShoppingListsCurrent.layoutManager = LinearLayoutManager(activity?.applicationContext!!)
        rvShoppingListsCurrent.adapter = adapter


        viewModel.getCurrentShoppingLists().observe(viewLifecycleOwner, Observer {
            adapter.lists = it
            adapter.notifyDataSetChanged()
            this.lists = it
        })

        fabList.setOnClickListener{
            CreateShoppingListDialog(
                object: CreateDialogListener {
                    override fun onCreateButtonClicked(list: ShoppingList) {
                        viewModel.upsertList(list)
                    }
                }).show(requireActivity().supportFragmentManager, "dupadupa")
        }
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(activity?.applicationContext!!, ShoppingCurrentItemActivity::class.java).apply {
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

