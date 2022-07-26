package com.jahanshahi.amirypto.data.repository

import com.jahanshahi.amirypto.data.remote.CoinPaprikaApi
import com.jahanshahi.amirypto.data.remote.dto.CoinDTO
import com.jahanshahi.amirypto.data.remote.dto.CoinDetailDTO
import com.jahanshahi.amirypto.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api:CoinPaprikaApi
) :CoinRepository{
    override suspend fun getCoins(): List<CoinDTO> = api.getCoins()

    override suspend fun getCoinById(coinId: String): CoinDetailDTO = api.getCoinById(coinId = coinId)
}