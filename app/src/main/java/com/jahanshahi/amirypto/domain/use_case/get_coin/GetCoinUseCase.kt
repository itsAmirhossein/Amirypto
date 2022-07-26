package com.jahanshahi.amirypto.domain.use_case.get_coin

import com.jahanshahi.amirypto.common.Resource
import com.jahanshahi.amirypto.data.remote.dto.toCoin
import com.jahanshahi.amirypto.data.remote.dto.toCoinDetail
import com.jahanshahi.amirypto.domain.model.Coin
import com.jahanshahi.amirypto.domain.model.CoinDetail
import com.jahanshahi.amirypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
  private val repository: CoinRepository
){
    operator fun invoke(coinId:String):Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId = coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        }catch (e : HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "A n unexpected error occurred."))
        }catch (e: IOException){
            emit(Resource.Error<CoinDetail>("Couldn't reach server. check your internet connection."))
        }
    }
}