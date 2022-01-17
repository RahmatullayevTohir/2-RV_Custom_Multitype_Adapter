package com.example.a2_rv_custom_multitype_adapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a2_rv_custom_multitype_adapter.R
import com.example.a2_rv_custom_multitype_adapter.model.User

class CustomAdapter(val users: List<User>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val Type_AVAILABLE_YES=0
    private val Type_AVAILABLE_NOT=1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == Type_AVAILABLE_YES){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_yes,parent,false);
            return CustomViewHolderYes(view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_not,parent,false)
        return CustomViewHolderNot(view)

    }

    override fun getItemViewType(position: Int): Int {
        val user = users[position]
        if (user.available)
            return Type_AVAILABLE_YES
        return Type_AVAILABLE_NOT
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = users.get(position)
        if (holder is CustomViewHolderYes){
            holder.name.setText(user.name)
        }
        else if (holder is CustomViewHolderNot){
            holder.name.setText(user.name)
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class CustomViewHolderYes(itemView: View):RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.name)
    }

    class CustomViewHolderNot(itemView: View):RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.name)
    }
}