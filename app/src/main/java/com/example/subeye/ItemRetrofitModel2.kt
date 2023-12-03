package com.example.subeye

data class ItemRetrofitModel2(
    var exitNo: Int? = null,
    var dirDesc: String? = null,
)

//JSON 구조에서 response ⊂ body ⊂ items(MutableList) ⊂ item(ItemRetrofitModel)임을 이용
//response.body.items.item[rnum]
data class MyItem2(val item:MutableList<ItemRetrofitModel>)
data class MyItems2(val items:MyItem2)
data class MyModel2(val body: MyItems2)
data class MyBody2(val response: MyModel2)