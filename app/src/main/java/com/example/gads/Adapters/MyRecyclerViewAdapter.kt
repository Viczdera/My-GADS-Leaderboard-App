package com.example.gads.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gads.Model.Hr
import com.example.gads.Model.HrItem
import com.example.gads.R

class MyRecyclerViewAdapter(val hr: List<HrItem>) :RecyclerView.Adapter<MyRecyclerViewAdapter.HrViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HrViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.fragment_first,parent,false)

        return HrViewHolder(view)
    }

    override fun getItemCount()= hr.size

    override fun onBindViewHolder(holder: MyRecyclerViewAdapter.HrViewHolder, position: Int) {

    }




    class HrViewHolder(val view: View) : RecyclerView.ViewHolder(view)


}

