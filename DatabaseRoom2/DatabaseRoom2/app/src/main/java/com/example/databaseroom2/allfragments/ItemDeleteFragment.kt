package com.example.databaseroom2.allfragments


import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.databaseroom2.data.ItemViewModel
import com.example.databaseroom2.R

class ItemDeleteFragment : Fragment() {
    private lateinit var myViewModel: ItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_item_delete, container, false)
        //crate viewModel object
        myViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        val itemName=view.findViewById<EditText>(R.id.item_name_delete)
        val delBtn=view.findViewById<Button>(R.id.btn_delete_item)
        delBtn.setOnClickListener{
            val nameToDelete = itemName.text.toString()  // Get the item name from EditText

            if (nameToDelete.isNotEmpty()) {
                myViewModel.deleteItem(nameToDelete)
                Toast.makeText(requireContext(), "Successfully Deleted!", Toast.LENGTH_LONG).show()
                itemName.text.clear()  // Clear the input field after deletion
            } else {
                Toast.makeText(requireContext(), "Please enter a valid item name!", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}
