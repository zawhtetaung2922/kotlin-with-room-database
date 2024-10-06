package com.example.databaseroom2.allfragments

import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.databaseroom2.R
import com.example.databaseroom2.data.Item

class ItemAdapter(private var itemList: List<Item>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.itemName)
        val itemPrice: TextView = itemView.findViewById(R.id.itemPrice)
        val itemQuantity: TextView = itemView.findViewById(R.id.itemQuantity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemName.text = item.name
        holder.itemPrice.text = "$ "+item.price.toString()
        holder.itemQuantity.text = item.quantity.toString()+" In stock"
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    // Helper function to update the adapter's item list
    fun updateItems(newItemList: List<Item>) {
        itemList = newItemList
        notifyDataSetChanged()
    }
}
