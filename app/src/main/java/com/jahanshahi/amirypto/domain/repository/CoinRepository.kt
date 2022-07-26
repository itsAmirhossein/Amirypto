package com.jahanshahi.amirypto.domain.repository

import com.jahanshahi.amirypto.data.remote.dto.CoinDTO
import com.jahanshahi.amirypto.data.remote.dto.CoinDetailDTO

interface CoinRepository {

    suspend fun getCoins(): List<CoinDTO>

    suspend fun getCoinById(coinId:String): CoinDetailDTO
}