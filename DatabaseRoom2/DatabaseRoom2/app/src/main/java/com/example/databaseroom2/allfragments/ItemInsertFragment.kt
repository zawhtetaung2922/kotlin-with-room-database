package com.example.databaseroom2.allfragments


import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.databaseroom2.R
import com.example.databaseroom2.data.Item
import com.example.databaseroom2.data.ItemViewModel

class ItemInsertFragment : Fragment() {
    private lateinit var myViewModel: ItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_insert, container, false)
        //crate viewModel object
        myViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        val nameField = view.findViewById<EditText>(R.id.et_item_name)
        val priceField = view.findViewById<EditText>(R.id.et_item_price)
        val quantityField = view.findViewById<EditText>(R.id.et_item_quantity)
        val insertButton = view.findViewById<Button>(R.id.btn_insert_item)

        insertButton.setOnClickListener {
            val name = nameField.text.toString()
            val price = priceField.text.toString().toDouble()
            val quantity = quantityField.text.toString().toInt()

            if (name.isNotEmpty() && price != null && quantity != null) {
                val newItem = Item(id = 0, name = name, price = price, quantity = quantity)
                myViewModel.insertItem(newItem)
                Toast.makeText(requireContext(),"Successfully added", Toast.LENGTH_LONG).show()
                nameField.text.clear()
                priceField.text.clear()
                quantityField.text.clear()
            }
        }
        return view
    }
}
