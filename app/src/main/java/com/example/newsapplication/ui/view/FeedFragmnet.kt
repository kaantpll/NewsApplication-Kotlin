package com.example.newsapplication.ui.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapplication.R
import com.example.newsapplication.core.adapter.NewsAdapter
import com.example.newsapplication.ui.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.card_item.*
import kotlinx.android.synthetic.main.fragments_feed.*

class FeedFragmnet : Fragment(R.layout.fragments_feed){

    private lateinit var viewModel : FeedViewModel
    private var adapter = NewsAdapter(arrayListOf())


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(FeedViewModel::class.java)
        viewModel.fetchDataFromAPI()

        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = adapter



        observeLiveData()

    }

    private fun observeLiveData() {
        viewModel.newsList.observe(viewLifecycleOwner, Observer {

            adapter.updateList(it.articles)

        })
    }
}