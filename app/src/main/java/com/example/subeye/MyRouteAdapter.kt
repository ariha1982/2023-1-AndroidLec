package com.example.subeye

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.subeye.databinding.ItemRouteBinding

class MyRouteViewHolder(val binding: ItemRouteBinding): RecyclerView.ViewHolder(binding.root)

class MyRouteAdapter(val context: Context, val datas: MutableList<ItemRetrofitModel>?): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun getItemCount(): Int{
        return datas?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
            = MyRouteViewHolder(ItemRouteBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding=(holder as MyRouteViewHolder).binding

        //add......................................
        val model = datas!![position]
        var lineImg: Int = 0
        var lineNm = model.subwayRouteName
        binding.afterSTTStationId.text = model.subwayStationId
        binding.afterSTTStationNm.text = model.subwayStationName
        binding.afterSTTLineNm.text = model.subwayRouteName
        when(lineNm){
            "1호선" -> { lineImg = R.drawable.line1 }
            "2호선" -> { lineImg = R.drawable.line2 }
            "3호선" -> { lineImg = R.drawable.line3 }
            "4호선" -> { lineImg = R.drawable.line4 }
            "5호선" -> { lineImg = R.drawable.line5 }
            "6호선" -> { lineImg = R.drawable.line6 }
            "7호선" -> { lineImg = R.drawable.line7 }
            "8호선" -> { lineImg = R.drawable.line8 }
            "9호선" -> { lineImg = R.drawable.line9 }
            "경의중앙" -> { lineImg = R.drawable.linegyeongui }
            "수인분당" -> { lineImg = R.drawable.linesb }
            "경춘" -> { lineImg = R.drawable.linegyeongchun }
            "경강" -> { lineImg = R.drawable.linegyeonggang }
            "인천1호선" -> { lineImg = R.drawable.lineincheon1 }
            "공항" -> { lineImg = R.drawable.lineairport }
            "신분당" -> { lineImg = R.drawable.linenewb }
            "에버라인" -> {lineImg = R.drawable.lineyongin}
            "의정부" -> {lineImg = R.drawable.lineuijeongbu}
            "우이신설" -> {lineImg = R.drawable.lineui}
        }
        binding.afterSTTTrasferLineImg.setImageResource(lineImg)

    }
}