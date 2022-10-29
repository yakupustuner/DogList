package com.learn.doglist.viewModel


import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.learn.doglist.API.Retrofit
import com.learn.doglist.Application
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogViewModel @Inject constructor(
    private val retrofit: Retrofit,
    private val application : Application


):ViewModel() {

    var dogImages = mutableListOf<String>()


     fun searchName(s:String){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val search = retrofit.getDogs("$s/images")
                if(search.isSuccessful){
                    val image = search.body()?.message
                    dogImages.clear()
                    if (image != null) {
                        dogImages.addAll(image)


                    }
                }



            }catch (e:Exception){
                Toast.makeText(application.applicationContext,"Error",Toast.LENGTH_LONG).show()
            }

        }

     }



}