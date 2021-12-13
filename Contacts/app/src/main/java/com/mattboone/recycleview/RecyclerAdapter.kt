package com.mattboone.recycleview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mattboone.recycleview.MainActivity

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    //private val mvm = MainViewModel()
    private val titles = MainViewModel.getTitles()
    private val details = MainViewModel.getDetails()
    private val images = MainViewModel.getImages()


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        var itemNumber: Int = 0

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)
            itemView.setOnClickListener {
                (itemView.context as MainActivity).sendData(itemView, itemNumber)
            }
        }
        fun onClick(view: View) {
            (itemView.context as MainActivity).sendData(itemView, itemNumber)
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        viewHolder.itemTitle.text = titles[MainViewModel.getRand(i,0)]
        viewHolder.itemDetail.text = details[MainViewModel.getRand(i,1)]
        viewHolder.itemImage.setImageResource(images[MainViewModel.getRand(i,2)])
        viewHolder.itemNumber = i
    }

    override fun getItemCount(): Int {
        return MainViewModel.getTitles().size
    }




}