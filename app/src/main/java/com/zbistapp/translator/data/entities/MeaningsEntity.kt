package com.zbistapp.translator.data.entities

import com.google.gson.annotations.SerializedName

data class MeaningsEntity(
    @SerializedName("translation") val translation: TranslationEntity,
)
