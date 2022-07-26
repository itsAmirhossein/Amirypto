package com.jahanshahi.amirypto.presentation.coin_detail

import com.jahanshahi.amirypto.domain.model.Coin
import com.jahanshahi.amirypto.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading:Boolean = false,
    val coin :CoinDetail? = null,
    val error:String = "",
)