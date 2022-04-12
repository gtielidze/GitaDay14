package com.myapplication.gitaday14.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.myapplication.gitaday14.R
import com.myapplication.gitaday14.databinding.CookieItemBinding
import com.myapplication.gitaday14.ui.model.Cookie

class MyAdapter(private val context: Context, private val clickListener: (Cookie) -> Unit) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    private var cookiesList: List<Cookie> = listOf()

    inner class ViewHolder(itemView: View, clickAtPosition: (Int) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        var binding = CookieItemBinding.bind(itemView)
        //private var binding = CookieItemBinding.inflate()


//        var name: ImageView = itemView.findViewById(R.id.nameTxtRCItem)
//        var flavor: TextView = itemView.findViewById(R.id.flavorTxtRCItem)
//        var expDate: TextView = itemView.findViewById(R.id.expDateTxtRCItem)
//        var brand: TextView = itemView.findViewById(R.id.brandTxtRCItem)
//        var weight: TextView = itemView.findViewById(R.id.weightTxtRCItem)

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
        //holder.name.text = "Name: ${cookiesList[position].name}"
//        Glide.with(context).load(cookiesList[position].name)
//            .override(300, 200)
//            .apply(RequestOptions().centerCrop())
//            //.transition(withCrossFade())
//            .into(holder.name)
//        holder.flavor.text = "Flavor ${cookiesList[position].flavour}"
//        holder.expDate.text = "Exp Date: ${cookiesList[position].expDate}"
//        holder.brand.text = "Brand: ${cookiesList[position].brand}"
//        holder.weight.text = "Weight: ${cookiesList[position].weight}"

        with(holder) {
            Glide.with(context).load(cookiesList[position].name)
                .override(300, 200)
                .apply(RequestOptions().centerCrop())
                //.transition(withCrossFade())
                .into(binding.nameTxtRCItem)
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
    fun setCoolieListItem(cookies: List<Cookie>) {
        this.cookiesList = cookies
        notifyDataSetChanged()
    }

}