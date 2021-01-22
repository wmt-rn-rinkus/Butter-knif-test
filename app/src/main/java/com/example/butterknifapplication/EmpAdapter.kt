package com.example.butterknifapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_emp_adapter.view.*

class EmpAdapter(val context: Context, val list: ArrayList<DataClass>) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (viewType == 0) {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.temp, parent, false))

        } else {
            return ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_emp_adapter, parent, false))

        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.empEmail.text = list[position].email
        holder.itemView.empFullname.text = list[position].fullName
        holder.itemView.empNumber.text = list[position].number
        Glide.with(context).load(list[position].image).circleCrop().into(holder.itemView.empImage)
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        return position % 2 * 2
    }

}