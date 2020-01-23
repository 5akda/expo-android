package com.smartexpo.android.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.smartexpo.android.models.Expo
import com.smartexpo.android.R

class ExpoListAdapter(private val expoItems: List<Expo>) :
        RecyclerView.Adapter<ExpoListAdapter.ExpoHolder>(){

        override fun getItemCount() = expoItems.size

        override fun onBindViewHolder(holder: ExpoHolder, position: Int) {
                holder.bind(expoItems[position])
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpoHolder {
                val inflater = LayoutInflater.from(parent.context)
                return ExpoHolder(inflater, parent)
        }

        class ExpoHolder(inflater: LayoutInflater, parent: ViewGroup) :
                RecyclerView.ViewHolder(inflater.inflate(R.layout.item_expo, parent, false)){
                private var mName: TextView? = null
                private var mLogo: ImageView

                init {
                        mName = itemView.findViewById(R.id.txt_name)
                        mLogo = itemView.findViewById(R.id.image)
                }

                fun bind(expo: Expo){
                        mName?.text = expo.name
                        Glide.with(itemView).load(R.mipmap.ic_launcher).into(mLogo)
                }
        }


}