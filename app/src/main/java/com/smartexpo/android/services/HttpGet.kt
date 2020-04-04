package com.smartexpo.android.services

import android.os.AsyncTask
import android.util.Log
import com.google.gson.Gson
import com.smartexpo.android.activities.presenters.ICheckin
import com.smartexpo.android.models.Expo
import okhttp3.OkHttpClient
import okhttp3.Request

class HttpGetExpoListTask(private val view: ICheckin.View?) : AsyncTask<String?, Void?, String?>(){

    private var expoList = ArrayList<Expo>()

    override fun onPreExecute() {
        super.onPreExecute()
        Log.i("CE-SmartExpo", "HTTP-GET")
        view?.showLoading()
    }

    override fun doInBackground(vararg params: String?): String? {
        val link =
            "https://raw.githubusercontent.com/parzival48/expo-android/master/mock/ExpoList.json"
        val client = OkHttpClient()
        try {
            val request = Request.Builder().url(link).build()
            val response = client.newCall(request).execute()
            return ""+response.body!!.string()
        }
        catch (e: Exception) {
            Log.i("CE-SmartExpo", e.toString())
        }
        return null
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)

        this.expoList.add(Gson().fromJson(result, Expo::class.java))

        Log.i("CE-SmartExpo", "HTTP-200")
        view?.hideLoading()
    }

    fun data(): List<Expo>{
        return expoList
    }


}