package com.zbistapp.translator.domain.entities

import com.google.gson.annotations.SerializedName

data class TranslationEntity(
    @SerializedName("text") val text: String,
)
