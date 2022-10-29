package com.learn.doglist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learn.doglist.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var dogListFragmentFactory: DogListFragmentFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.fragmentFactory = dogListFragmentFactory
        setContentView(R.layout.activity_main)
    }
}