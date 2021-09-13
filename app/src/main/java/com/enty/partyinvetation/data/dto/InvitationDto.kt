package com.enty.partyinvetation.data.dto

data class InvitationDto(
    val fromName:String,
    val backgroundUrl: String,
    val fromImgUrl: String,
    val guest: List<GuestDto>
)
