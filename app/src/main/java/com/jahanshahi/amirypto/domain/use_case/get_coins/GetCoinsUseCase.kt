package com.jahanshahi.amirypto.domain.use_case.get_coins

import com.jahanshahi.amirypto.common.Resource
import com.jahanshahi.amirypto.data.remote.dto.toCoin
import com.jahanshahi.amirypto.domain.model.Coin
import com.jahanshahi.amirypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
  private val repository: CoinRepository
){
    operator fun invoke():Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        }catch (e : HttpException){
            emit(Resource.Error(e.localizedMessage ?: "A n unexpected error occurred."))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. check your internet connection."))
        }
    }
}