package com.myapplication.gitaday14.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.gitaday14.R
import com.myapplication.gitaday14.databinding.CookieItemBinding
import com.myapplication.gitaday14.ui.model.Cookie
import com.myapplication.gitaday14.ui.utils.loadImage

class MyAdapter( private val clickListener: (Cookie) -> Unit) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    private var cookiesList = mutableListOf<Cookie>()

    inner class ViewHolder(itemView: View, clickAtPosition: (Int) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        var binding = CookieItemBinding.bind(itemView)

        init {
            itemView.setOnClickListener {
                clickAtPosition(adapterPosition)
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cookie_item, parent, false)
        ) {
            clickListener(cookiesList[it])
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder) {
            binding.ImgName.loadImage(cookiesList[position].name)
            binding.brandTxtRCItem.text = "Brand: ${cookiesList[position].brand}"
            binding.flavorTxtRCItem.text = "Flavor ${cookiesList[position].flavour}"
            binding.expDateTxtRCItem.text = "Exp Date: ${cookiesList[position].expDate}"
            binding.weightTxtRCItem.text = "Weight: ${cookiesList[position].weight}"
        }
    }

    override fun getItemCount(): Int {
        return cookiesList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setCoolieListItem(cookies: MutableList<Cookie>) {
        this.cookiesList.clear()
        this.cookiesList.addAll(cookies)
        notifyDataSetChanged()
    }

}