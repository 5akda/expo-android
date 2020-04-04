package com.smartexpo.android.activities.presenters

import android.os.AsyncTask
import android.util.Log
import com.smartexpo.android.models.Expo
import okhttp3.OkHttpClient
import okhttp3.Request

class CheckinPresenter(var view: ICheckin.View? = null) : ICheckin.Presenter {

    override fun scanQRCode() : Char {
        // QR Code scanner here
        return 'G'
    }

    override fun cleanUp(){
        view = null
    }

    override fun loadExpoList() {

        HttpGetTask(view).execute()

    }

    class HttpGetTask(private val view: ICheckin.View?) : AsyncTask<String?, Void?, List<Expo>?>(){

        override fun onPreExecute() {
            super.onPreExecute()
            Log.i("CE-SmartExpo", "Loading")
            view?.showLoading()
        }

        override fun doInBackground(vararg params: String?): List<Expo>? {
            val link =
                "https://raw.githubusercontent.com/parzival48/FiniteAutomata/master/README.md"
            try {
                val client = OkHttpClient()
                val request = Request.Builder().url(link).build()
                val response = client.newCall(request).execute()
                val result = response.body!!.string()
                Log.i("SmartExpo", result)



            } catch (e: Exception) {

            }
            return listOf(
                Expo("Motor Show"),
                Expo("Commart"),
                Expo("Mobile Expo"),
                Expo("งานหนังสือ")
            )
        }

        override fun onPostExecute(result: List<Expo>?) {
            super.onPostExecute(result)
            view?.showExpoList(result!!)
            Log.i("CE-SmartExpo", "Done")
            view?.hideLoading()
        }
    }
}