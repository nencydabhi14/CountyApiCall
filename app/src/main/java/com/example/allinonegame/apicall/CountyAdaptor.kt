package com.example.allinonegame.apicall

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.allinonegame.R

class CountyAdaptor(val apiCallCountries: ApiCallCountries,val list: List<CountyModelItem>?) : RecyclerView.Adapter<CountyAdaptor.ViewData>() {

    class ViewData(itemView: View) : ViewHolder(itemView){
        var county_image = itemView.findViewById<ImageView>(R.id.county_image)
        var txt1 = itemView.findViewById<TextView>(R.id.txt1)
        var txt2 = itemView.findViewById<TextView>(R.id.txt2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        var view = LayoutInflater.from(apiCallCountries).inflate(R.layout.itemfile,parent,false)
        return ViewData(view)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        holder.txt1.text = list?.get(position)?.capital
        holder.txt2.text = list?.get(position)?.timezones.toString()

        Glide.with(apiCallCountries).load(list?.get(position)!!.flags?.png).into(holder.county_image)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

}