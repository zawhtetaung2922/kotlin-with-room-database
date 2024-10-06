package com.example.databaseroom2.allfragments


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.recyclerview.widget.*
import com.example.databaseroom2.R
import com.example.databaseroom2.data.ItemViewModel

class ItemLIstFragment : Fragment() {

    private lateinit var myViewModel: ItemViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_item_l_ist, container, false)

        //create viewModel object
        myViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)

        // Initialize RecyclerView and Adapter
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        itemAdapter = ItemAdapter(emptyList())
        recyclerView.adapter = itemAdapter

        // Observe LiveData from ViewModel

        myViewModel.showAllItems().observe(viewLifecycleOwner, Observer { items ->
            // Update the adapter's item list
            itemAdapter.updateItems(items)
        })


        return view
    }
}
