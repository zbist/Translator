package com.zbistapp.translator.data.entities

import com.google.gson.annotations.SerializedName

data class MainEntity(
    @SerializedName("text") val text: String,
    @SerializedName("meanings") val meanings: List<MeaningsEntity>
)
