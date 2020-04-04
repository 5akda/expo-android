package com.smartexpo.android.activities.presenters

import com.smartexpo.android.models.Expo
import com.smartexpo.android.services.HttpGetExpoListTask

class CheckinPresenter(var view: ICheckin.View? = null) : ICheckin.Presenter {

    override fun scanQRCode() : Char {
        // QR Code scanner here
        return 'G'
    }

    override fun cleanUp(){
        view = null
    }

    override fun loadExpoList() : List<Expo> {
        val httpClient = HttpGetExpoListTask(view)
        httpClient.execute()
        return httpClient.data()
    }

}