package com.example.subeye

data class ItemRetrofitModel(
    var subwayStationId: String? = null,
    var subwayStationName: String? = null,
    var subwayRouteName: String? = null,
)

//JSON 구조에서 response ⊂ body ⊂ items(MutableList) ⊂ item(ItemRetrofitModel)임을 이용
//response.body.items.item[rnum]
data class MyItem(val item:MutableList<ItemRetrofitModel>)
data class MyItems(val items:MyItem)
data class MyModel(val body: MyItems)
data class MyBody(val response: MyModel)
