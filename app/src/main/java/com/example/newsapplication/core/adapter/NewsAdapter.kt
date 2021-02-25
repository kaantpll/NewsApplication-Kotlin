package com.example.newsapplication.core.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.R
import com.example.newsapplication.core.model.NewsResult
import com.example.newsapplication.databinding.CardItemBinding
import com.example.newsapplication.ui.view.FeedFragmnet

class NewsAdapter(var newsList : List<NewsResult>) : RecyclerView.Adapter<NewsAdapter.MyViewHolder>(),OnClickListener {

    class MyViewHolder(var view : CardItemBinding) : RecyclerView.ViewHolder(view.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<CardItemBinding>(inflater,
            R.layout.card_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.view.myApp = newsList[position]
        holder.view.listener = this
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun updateList(list : List<NewsResult>){

        newsList = list
        notifyDataSetChanged()
    }

    override fun onClickListener(v: View) {

        v.setOnClickListener {

            val action = ActionOnlyNavDirections(R.id.action_feedFragmnet_to_detailsFragment)
            Navigation.findNavController(it).navigate(action)
        }
    }


}