package com.smartexpo.android.activities.presenters

import com.smartexpo.android.models.Expo

interface ICheckin {
    interface View {
        fun renderExpoList()
    }
    interface Presenter {
        fun scanQRCode() : Char
        fun cleanUp()
        fun loadExpoList() : List<Expo>
    }
}