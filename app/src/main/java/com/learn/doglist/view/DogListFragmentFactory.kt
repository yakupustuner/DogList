package com.learn.doglist.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.learn.doglist.adapter.DogAdapter
import javax.inject.Inject


class DogListFragmentFactory @Inject constructor(
    private val qlide:RequestManager,
    private val dogAdapter: DogAdapter,

):FragmentFactory(){


    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            FirstFragment::class.java.name -> FirstFragment(dogAdapter,qlide)
            else -> super.instantiate(classLoader, className)
        }
        }
}