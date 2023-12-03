package com.example.subeye

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.subeye.databinding.ItemLandmarkBinding
import com.example.subeye.databinding.ItemRouteBinding

class MyLandmarkViewHolder(val binding: ItemLandmarkBinding): RecyclerView.ViewHolder(binding.root)

class MyLandmarkAdapter(val context: Context, val datas: MutableList<ItemRetrofitModel2>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun getItemCount(): Int{
        return datas?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
            = MyLandmarkViewHolder(ItemLandmarkBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding=(holder as MyLandmarkViewHolder).binding

        //add......................................
        val model = datas!![position]
        binding.afterSTT2Lanmark.text = model.dirDesc
        binding.afterSTT2ExitNo.text = model.exitNo.toString()

    }
}