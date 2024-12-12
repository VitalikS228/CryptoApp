package com.example.cryptoapp.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import com.example.cryptoapp.domain.StockItem
import com.squareup.picasso.Picasso

class ListBinder : ListAdapter<StockItem, ListBinder.ViewHolder>(DiffChecker()) {

    interface ItemsInteractionListener {
        fun onClick(shopItem: StockItem)
    }

    var itemsInteractionListener: ItemsInteractionListener? = null

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardView = view.findViewById<CardView>(R.id.cardView_stockItem)
        val image = view.findViewById<ImageView>(R.id.pic)
        val currency = view.findViewById<TextView>(R.id.currency)
        val price = view.findViewById<TextView>(R.id.price)
        val update = view.findViewById<TextView>(R.id.update)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.stock_item, viewGroup, false)

        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val stockItem = getItem(position)
        viewHolder.cardView.setOnClickListener {
            itemsInteractionListener?.onClick(stockItem)
        }
        Picasso.get().load(stockItem.iconUrl).into(viewHolder.image)
        viewHolder.currency.text = stockItem.fromSymbol
        viewHolder.price.text = stockItem.price.toString()


        viewHolder.update.text = convertTime(stockItem.lastUpdate)
    }


}



