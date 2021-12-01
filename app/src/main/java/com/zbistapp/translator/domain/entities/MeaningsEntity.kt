package com.zbistapp.translator.domain.entities

import com.google.gson.annotations.SerializedName

data class MeaningsEntity(
    @SerializedName("translation") val translation: TranslationEntity,
)
