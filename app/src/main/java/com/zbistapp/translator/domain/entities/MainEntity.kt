package com.zbistapp.translator.domain.entities

import com.google.gson.annotations.SerializedName

data class MainEntity(
    @SerializedName("text") val text: String,
    @SerializedName("meanings") val meanings: List<MeaningsEntity>
)
