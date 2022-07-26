package com.jahanshahi.amirypto.di

import com.jahanshahi.amirypto.common.Constants
import com.jahanshahi.amirypto.data.remote.CoinPaprikaApi
import com.jahanshahi.amirypto.data.repository.CoinRepositoryImpl
import com.jahanshahi.amirypto.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCoinPaprikaAPi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api:CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api = api)
    }
}