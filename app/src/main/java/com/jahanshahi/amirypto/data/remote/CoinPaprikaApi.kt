package com.jahanshahi.amirypto.data.remote

import com.jahanshahi.amirypto.data.remote.dto.CoinDTO
import com.jahanshahi.amirypto.data.remote.dto.CoinDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    @GET("coins")
    suspend fun getCoins():List<CoinDTO>

    @GET("coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId:String): CoinDetailDTO
}