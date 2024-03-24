package com.betrybe.trybnb.data.models

import com.google.gson.annotations.SerializedName

data class UrlParameter(
    @SerializedName("bookingid")
    val id: Int
)

data class DataReservation(
    @SerializedName("firstname")
    val firstName: String,
    @SerializedName("lastname")
    val lastName: String,
    @SerializedName("totalprice")
    val totalPrice: Int,
    @SerializedName("bookingdates")
    val bookingDates: DatesInfo,
    @SerializedName("additionalneeds")
    val additionalNeeds: String
)