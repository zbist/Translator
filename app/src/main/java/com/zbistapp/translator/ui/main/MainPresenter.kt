package com.zbistapp.translator.ui.main

import com.zbistapp.translator.data.NetworkRepoImpl
import com.zbistapp.translator.domain.network.INetworkRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers

class MainPresenter(
    private val networkRepo: INetworkRepo
) : MainContract.Presenter {

    private var view: MainContract.View? = null
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onViewAttach(view: MainContract.View) {
        this.view = view
    }

    override fun onViewDetach() {
        view = null
        compositeDisposable.dispose()
    }

    override fun onSearchClicked(word: String) {
        if (word.isNotBlank()) {
            view?.setLoading(true)
            compositeDisposable +=
                networkRepo.fetchWords(word)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        view?.setTranslation(it)
                        view?.setLoading(false)
                    }, {
                        view?.setError(it)
                        view?.setLoading(false)
                    })
        }
    }

}