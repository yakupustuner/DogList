package com.learn.doglist.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.RequestManager
import com.learn.doglist.R
import com.learn.doglist.adapter.DogAdapter
import com.learn.doglist.databinding.FragmentFirstBinding
import com.learn.doglist.viewModel.DogViewModel
import javax.inject.Inject


class FirstFragment @Inject constructor(
   private  var dogAdapter : DogAdapter,
   val glide: RequestManager,

) : Fragment(R.layout.fragment_first), androidx.appcompat.widget.SearchView.OnQueryTextListener {
private lateinit var fragmentBinding: FragmentFirstBinding
    lateinit var viewModel : DogViewModel






    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFirstBinding.bind(view)
        fragmentBinding = binding

        fragmentBinding.search.setOnQueryTextListener(this)
        viewModel = ViewModelProvider(requireActivity()).get(DogViewModel::class.java)
        dogAdapter = DogAdapter(glide,viewModel.dogImages)
        fragmentBinding.recyclerView.layoutManager = GridLayoutManager(requireContext(),3)
        fragmentBinding.recyclerView.adapter = dogAdapter


    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        if (!p0.isNullOrEmpty()){
            searchImage(p0)
        }
        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        return true
    }

   @SuppressLint("NotifyDataSetChanged")
   private fun searchImage(c:String){
       viewModel.searchName(c)
       dogAdapter.notifyDataSetChanged()
   }




}