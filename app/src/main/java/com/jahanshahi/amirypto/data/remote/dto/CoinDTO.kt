package com.jahanshahi.amirypto.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.jahanshahi.amirypto.domain.model.Coin

data class CoinDTO(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDTO.toCoin(): Coin = Coin(
    id = id,
    isActive = isActive,
    name = name,
    rank = rank,
    symbol = symbol
)