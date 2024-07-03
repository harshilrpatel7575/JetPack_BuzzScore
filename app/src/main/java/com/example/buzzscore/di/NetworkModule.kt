package com.example.buzzscore.di

import com.example.buzzscore.data.remote.models.ElenaApiService
import com.example.buzzscore.util.BASE_URL
import com.example.buzzscore.util.Requestinterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun okHttp(): OkHttpClient{
        val loggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(Requestinterceptor())
            .build()
    }

    @Provides
    fun retrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    fun eleneApiService(retrofit: Retrofit): ElenaApiService{
        return retrofit.create(ElenaApiService::class.java)

    }
}