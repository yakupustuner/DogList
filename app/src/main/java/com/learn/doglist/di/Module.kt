package com.learn.doglist.di


import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.learn.doglist.R
import com.learn.doglist.adapter.DogAdapter
import com.learn.doglist.util.Util.BASE_URL
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@dagger.Module
@InstallIn(SingletonComponent::class)
object Module {


  @Singleton
  @Provides
  fun injectRetrofit():com.learn.doglist.API.Retrofit{
      return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
          .baseUrl(BASE_URL).build().create(com.learn.doglist.API.Retrofit::class.java)
  }

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext application : Context): com.learn.doglist.Application{
        return application as com.learn.doglist.Application
    }



    @Singleton
    @Provides
    fun injectGlide(@ApplicationContext context: Context) = Glide
        .with(context).setDefaultRequestOptions(RequestOptions().placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground))


    @Singleton
    @Provides
    fun provideAdapter(@ApplicationContext context: Context) = DogAdapter(
        injectGlide(context), images =
        arrayListOf())



}