package com.zbistapp.translator.ui.main

import com.zbistapp.translator.domain.entities.MainEntity
import com.zbistapp.translator.domain.entities.TranslationEntity

class MainContract {

    interface View {

        fun setLoading(isLoading: Boolean)
        fun setTranslation(listOfTranslate: List<MainEntity>)
        fun setError(t: Throwable)
    }

    interface Presenter {

        fun onViewAttach(view: View)
        fun onViewDetach()
        fun onSearchClicked(word: String)
    }
}