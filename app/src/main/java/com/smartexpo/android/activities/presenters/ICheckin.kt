package com.smartexpo.android.activities.presenters

import com.smartexpo.android.models.Expo

interface ICheckin {
    interface View {
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter {
        fun scanQRCode() : Char
        fun cleanUp()
        fun loadExpoList() : List<Expo>
    }
}