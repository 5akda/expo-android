package com.smartexpo.android.activities.presenters

import com.smartexpo.android.models.Expo

class CheckinPresenter(private var view: ICheckin.View? = null): ICheckin.Presenter {
    override fun scanQRCode() : Char {
        // QR Code scanner here
        return 'G'
    }

    override fun cleanUp(){
        view = null
    }

    override fun loadExpoList(): List<Expo> {
        return listOf(
            Expo("Motor Show"),
            Expo("Commart"),
            Expo("Mobile Expo"),
            Expo("งานหนังสือ")
        )
    }
}