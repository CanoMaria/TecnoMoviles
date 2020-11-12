package com.tm.canomariaayelen.model

import com.google.gson.annotations.SerializedName

data class Objeto (
    @SerializedName("created_by")var created_by: String? = null,
    @SerializedName(" description")var description: String? = null,
    @SerializedName("favorite_count")var favorite_count:String? = null,
    @SerializedName("id")var id: Int? = null,
    @SerializedName("items") var items: ArrayList<Pelicula>
 )