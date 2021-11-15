package com.mattboone.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private val mvm = MainViewModel()
    private val titles = mvm.getTitles()
    private val details = mvm.getDetails()
    private val images = mvm.getImages()


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        viewHolder.itemTitle.text = titles[mvm.nextRand()!!]
        viewHolder.itemDetail.text = details[mvm.nextRand()!!]
        viewHolder.itemImage.setImageResource(images[mvm.nextRand()!!])
    }

    override fun getItemCount(): Int {
        return mvm.getTitles().size
    }

}