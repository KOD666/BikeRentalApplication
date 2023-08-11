package com.example.bikerentalapplication.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.bikerentalapplication.R

class CustomRecyclerAdpter1(var context: Context, var arraylist: ArrayList<Customdetail>) :
    RecyclerView.Adapter<CustomRecyclerAdpter1.Myholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myholder {
        //TODO("Not yet implemented")
        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.custom_recycler, parent, false)
        return Myholder(view)
    }

    class Myholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView = itemView.findViewById(R.id.custom_recycler_TextView)
        var image: ImageView = itemView.findViewById(R.id.custom_recycler_image)

    }

    override fun onBindViewHolder(holder: Myholder, position: Int) {
        //TODO("Not yet implemented")
        holder.name.text = arraylist.get(position).name
        holder.image.setImageResource(arraylist.get(position).image)
        holder.itemView.setOnClickListener {
            var bundle : Bundle = Bundle()
            bundle.putString("CAT_NAME",arraylist.get(position).name)
            bundle.putInt("CAT_IMAGE",arraylist.get(position).image)


           val intent = Intent(context, BikeDeatailActivity::class.java)
            intent.putExtras(bundle)
            context?.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        //TODO("Not yet implemented")
        return arraylist.size
    }


}
