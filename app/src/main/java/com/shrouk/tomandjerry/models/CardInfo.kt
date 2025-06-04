package com.shrouk.tomandjerry.models


data class CardInfo(
    val productImg: Int,
    val productTitle: String,
    val productDescription: String,
    val productPrice: String,
    val productPriceBeforeDiscount: String? = null
)
