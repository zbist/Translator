package com.zbistapp.translator.data.entities

import com.google.gson.annotations.SerializedName

data class TranslationEntity(
    @SerializedName("text") val text: String,
)
