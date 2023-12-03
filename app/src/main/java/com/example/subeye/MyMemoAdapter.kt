package com.example.subeye

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.subeye.databinding.ItemMemoBinding
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

class MyMemoViewHolder(val binding: ItemMemoBinding) : RecyclerView.ViewHolder(binding.root)

class MyMemoAdapter(val context: Context, val itemList: MutableList<ItemMemoModel>): RecyclerView.Adapter<MyMemoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyMemoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MyMemoViewHolder(ItemMemoBinding.inflate(layoutInflater))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyMemoViewHolder, position: Int) {
        val data = itemList.get(position)

        holder.binding.run {
            itemTitleView.text=data.title
            itemDateView.text=data.date
            itemLocationView.text=data.location
            itemContentView.text=data.contents
        }
        /*val imageRef = MyApplication.storage.reference.child("images/${data.docId}.jpg")
        imageRef.downloadUrl.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                GlideApp.with(context)
                    .load(task.result)
                    .into(holder.binding.itemImageView)
            }
        }*/
    }
}